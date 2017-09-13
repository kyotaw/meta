/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.connect;

/**
 *
 * @author Kyota Watanabe
 */
public enum ErrorCode {
    INVALID_AUTH_INFO(100),
    OWNER_NOT_FOUND(101),
    OWNER_ALREADY_EXISTS(102),
    MONO_NOT_FOUND(200),
    MONO_ALREADY_EXISTS(201),
    
    PROCESSING_ERROR(500);
    
    private final int value;
    
    ErrorCode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return this.value;
    }
}
