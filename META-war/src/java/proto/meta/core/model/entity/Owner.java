/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.model.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.EmbeddedId;
import javax.persistence.Column;

import proto.meta.core.model.entity.HashedPassword;

/**
 *
 * @author Kyota Watanabe
 */
@Entity
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @Column(unique = true)
    private String ownerId;
    private HashedPassword password;
    
    public Owner() {}
    
    public Owner(String ownerId, HashedPassword password) {
        this.ownerId = ownerId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * @return the ownerId
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
    public HashedPassword getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(HashedPassword password) {
        this.password = password;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if (ownerId != other.getOwnerId() || !password.equals(other.getPassword())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proto.meta.core.model.entity.Owner[ userId=" + ownerId + " ]";
    }
    
}
