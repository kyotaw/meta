/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletRequest;

import proto.murmur.core.connect.ErrorResponse;
import proto.murmur.core.connect.ErrorCode;
import proto.murmur.core.connect.SuccessResponse;
import proto.murmur.core.model.dto.OwnerDto;
import proto.murmur.core.model.entity.Owner;
import proto.murmur.core.service.OwnerService;
import proto.murmur.core.controller.OwnerResponse;
import proto.murmur.core.service.AuthService;

/**
 *
 * @author Kyota Watanabe
 */

@ApplicationScoped
@Path("owners")
public class OwnersController {
    
    @Inject OwnerService ownerService;
    @Inject AuthService ahuthService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@QueryParam("ownerId") String ownerId) {
        Owner owner = ownerService.find(ownerId);
        if (owner == null) {
            return Response.ok(new ErrorResponse(ErrorCode.OWNER_NOT_FOUND, "not found").toString()).build();
        } else {
            return Response.ok(new OwnerResponse(owner).toString()).build();
        }
    }
    
    @Path("login")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(OwnerDto dto, @Context HttpServletRequest req) {
        Owner owner = ahuthService.login(dto, req);
        if (owner == null) {
            return Response.ok(new ErrorResponse(ErrorCode.INVALID_AUTH_INFO, "login failed").toString()).build();
        } else {
            return Response.ok(new OwnerResponse(owner).toString()).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(OwnerDto dto) {
        Owner owner = ownerService.create(dto);
        if (owner == null) {
            return Response.ok(new ErrorResponse(ErrorCode.OWNER_ALREADY_EXISTS, "The onwer already exists").toString()).build();
        } else {
            return Response.ok(new SuccessResponse().toString()).build();
        }
    }
}
