/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.connect;

import java.io.Serializable;

/**
 *
 * @author Kyota Watanabe
 */
public class ResponseStatus implements Serializable {
    private String status;
    
    static public ResponseStatus success() {
        return new ResponseStatus("success");
    }
    
    static public ResponseStatus error() {
        return new ResponseStatus("error");
    }
    
    public ResponseStatus(String status) {
        this.status = status;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return status;
    }
}
