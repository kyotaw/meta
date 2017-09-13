/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.connect;

import java.math.BigDecimal;
import proto.meta.core.connect.Response;
import proto.meta.core.connect.ResponseStatus;
import proto.meta.core.connect.JSON;

/**
 *
 * @author Kyota Watanabe
 */
public class ErrorResponse implements Response {
    private ResponseStatus status;
    private ErrorCode errorCode;
    private String message;
    
    public ErrorResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.status = ResponseStatus.error();
        this.message = message;
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

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    public JSON toJson() {
        return new JSON()
            .add("status", status.toString())
            .add("errorCode", errorCode.getValue())
            .add("message", message);
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
    
}
