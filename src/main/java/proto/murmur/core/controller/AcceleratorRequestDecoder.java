/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import proto.murmur.core.model.AcceleratorRequest;

/**
 *
 * @author Kyota Watanabe
 */
public class AcceleratorRequestDecoder implements Decoder.Text<AcceleratorRequest>{
    
    @Override
    public void init(EndpointConfig config) {
    }
    
    @Override
    public void destroy() {
    }
    
    @Override
    public boolean willDecode(String text) {
        return true;
    }
    
    @Override
    public AcceleratorRequest decode(String text) throws DecodeException {;
        return new AcceleratorRequest();
    }
}
