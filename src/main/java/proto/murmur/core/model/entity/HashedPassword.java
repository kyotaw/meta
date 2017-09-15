/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.model.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

import proto.murmur.core.crypto.Hash;

/**
 *
 * @author Kyota Watanabe
 */

@Embeddable
public class HashedPassword {
    private String password;
    
    public HashedPassword() {}
    
    public HashedPassword(String plainPassword, String salt) {
        this.password = Hash.encrypt(plainPassword, salt);
    }
    
    public String getPassword() {
        return password;
    }
 
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof HashedPassword)) {
            return false;
        }
        HashedPassword other = (HashedPassword) object;
        if (other.getPassword() != other.getPassword()) {
            return false;
        }
        return true;
    }
}
