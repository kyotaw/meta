/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.connect;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Kyota Watanabe
 */
public class JSON {
    static private ObjectMapper objectMapper = new ObjectMapper();
    private JsonObjectBuilder builder;
    
    public JSON() {
        this.builder = Json.createObjectBuilder();
    }

    public JSON add(String name, String value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, BigInteger value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, BigDecimal value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, int value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, long value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, double value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON add(String name, boolean value) {
        this.builder.add(name, value);
        return this;
    }

    public JSON addNull(String name) {
        this.builder.addNull(name);
        return this;
    }

    public JSON add(String name, JSON json) {
        this.builder.add(name, json.getJsonObjectBuilder());
        return this;
    }
    
    static public <T extends Object> T readValue(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    
    static public <T extends Object> T readValue(InputStream json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (JsonProcessingException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    
    private JsonObjectBuilder getJsonObjectBuilder() {
        return builder;
    }
    
    @Override
    public String toString() {
        return this.builder.build().toString();
    }
            
}
