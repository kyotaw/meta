/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityExistsException;

import proto.murmur.core.model.entity.Mono;
import proto.murmur.core.model.dto.NewMonoDto;
import proto.murmur.core.service.MonoService;
import proto.murmur.core.connect.ErrorResponse;
import proto.murmur.core.connect.ErrorCode;
import proto.murmur.core.controller.MonoResponse;

/**
 *
 * @author Kyota Watanabe
 */

@ApplicationScoped
@Path("monos")
public class MonosController {
    @Inject MonoService monoService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(
            @QueryParam("model") String model,
            @QueryParam("modelId") String modelId,
            @QueryParam("vendor") String vendor) {
        
        Mono mono = monoService.find(model, modelId, vendor);
        if (mono == null) {
            return Response.ok(new ErrorResponse(ErrorCode.MONO_NOT_FOUND, "not found").toString()).build();
        } else {
            return Response.ok(new MonoResponse(mono).toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(NewMonoDto dto) {
        try {
            Mono mono = monoService.register(dto);
            if (mono == null) {
                return Response.ok(new ErrorResponse(ErrorCode.MONO_ALREADY_EXISTS, "The Mono already exists").toString()).build();
            } else {
                return Response.ok(new MonoResponse(mono).toString()).build();
            }
        //} catch (EntityExistsException e) {
            
        } catch (Exception e) {
            return Response.ok(new ErrorResponse(ErrorCode.PROCESSING_ERROR, "register failed").toString()).build();
        }
    }
}
