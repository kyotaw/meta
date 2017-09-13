/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.model.dto;

import java.io.Serializable;

/**
 *
 * @author Kyota Watanabe
 */
public class OwnerDto implements Serializable {
    private String ownerId;
    private String password;
    
    OwnerDto() {}

    /**
     * @return the userId
     */
    public String getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
