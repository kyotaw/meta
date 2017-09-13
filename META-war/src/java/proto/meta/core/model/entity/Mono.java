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
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import proto.meta.core.model.entity.MonoId;

/**
 *
 * @author Kyota Watanabe
 */
@Entity
public class Mono implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private MonoId monoId;
    
    private String name;
    
    private String hash;
    
    public Mono() {}
    
    public Mono(MonoId id, String name) {
        this.monoId = id;
        this.name = name;
        this.hash = id.getHash();
    }

    /**
     * @return the monoId
     */
    public MonoId getMonoId() {
        return monoId;
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return the hash
     */
    public String getHash() {
        return hash;
    }
    
    @Override
    public int hashCode() {
        return monoId.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mono)) {
            return false;
        }
        Mono other = (Mono) object;
        if (monoId.equals(other.getMonoId())) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "proto.meta.core.model.entity.Mono[ id=" + getMonoId().hashCode() + " ]";
    }

}
