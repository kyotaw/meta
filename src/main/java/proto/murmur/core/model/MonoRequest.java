/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.model;

import javax.websocket.Session;

import proto.murmur.core.model.MonoType;

/**
 *
 * @author Kyota Watanabe
 */
public class MonoRequest {

    private MonoType monoType;
    private Session session;

    public MonoRequest(MonoType monoType) {
        this.monoType = monoType;
        this.session = null;
    }

    /**
     * @return the monoType
     */
    public MonoType getMonoType() {
        return monoType;
    }

    /**
     * @return the session
     */
    public Session getSession() {
        return session;
    }

    /**
     * @param session the session to set
     */
    public void setSession(Session session) {
        this.session = session;
    }

}
