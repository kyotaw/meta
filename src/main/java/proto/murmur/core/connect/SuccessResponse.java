/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.connect;

import proto.murmur.core.connect.JSON;
/**
 *
 * @author Kyota Watanabe
 */
public class SuccessResponse implements Response {
    private ResponseStatus status;
    
    public SuccessResponse() {
        this.status = ResponseStatus.success();
    }

    /**
     * @return the status
     */
    public ResponseStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
    
    public JSON toJson() {
        return new JSON()
            .add("status", status.toString());
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
}
