/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import proto.meta.core.model.dto.OwnerDto;
import proto.meta.core.connect.JSON;

/**
 *
 * @author Kyota Watanabe
 */

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class NewOwnerDtoDeserializer implements MessageBodyReader<OwnerDto> {
    @Override
    public boolean isReadable(
        Class<?> type,
        Type genericType,
        Annotation[] annotations,
        MediaType mediaType) {
        
        return type == OwnerDto.class;
    }

    @Override
    public OwnerDto readFrom(
        Class<OwnerDto> type,
        Type genericType,
        Annotation[] annotations,
        MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders,
        InputStream entityStream) throws IOException, WebApplicationException {
        
        return JSON.readValue(entityStream, OwnerDto.class);
    }
}
