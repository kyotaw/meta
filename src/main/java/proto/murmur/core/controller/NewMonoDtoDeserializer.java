/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

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

import proto.murmur.core.model.dto.NewMonoDto;
import proto.murmur.core.connect.JSON;

/**
 *
 * @author Kyota Watanabe
 */

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class NewMonoDtoDeserializer implements MessageBodyReader<NewMonoDto> {
    @Override
    public boolean isReadable(
        Class<?> type,
        Type genericType,
        Annotation[] annotations,
        MediaType mediaType) {
        
        return type == NewMonoDto.class;
    }

    @Override
    public NewMonoDto readFrom(
        Class<NewMonoDto> type,
        Type genericType,
        Annotation[] annotations,
        MediaType mediaType,
        MultivaluedMap<String, String> httpHeaders,
        InputStream entityStream) throws IOException, WebApplicationException {
        
        return JSON.readValue(entityStream, NewMonoDto.class);
    }

}
