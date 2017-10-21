/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.CloseReason;

import proto.murmur.core.model.AcceleratorRequest;
import proto.murmur.core.controller.AcceleratorRequestDecoder;
import proto.murmur.core.model.AcceleratorRequest;

/**
 *
 * @author Kyota Watanabe
 */
 
@ServerEndpoint(value="/accelerator", decoders={AcceleratorRequestDecoder.class})
public class AcceleratorEndPoint {
    AcceleratorRequest request;
    
    public AcceleratorEndPoint() {
        request = null;
    }
    
    @OnOpen
    public void open(Session session, EndpointConfig config) {
        request = null;
    }
   
    @OnMessage
    public void recieveRequest(Session session, AcceleratorRequest request) {
        if (this.request == null) {
            this.request = request;
        }
    }
    
    @OnClose
    public void onClose(Session session, CloseReason reason) {
        String s = reason.toString();
        s = reason.toString();
    }
    
    @OnError
    public void onError(Session session, Throwable err) {
        String s = err.getMessage();
        s = err.toString();
    }
}
