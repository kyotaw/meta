/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.model.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

import proto.meta.core.crypto.Hash;

/**
 *
 * @author Kyota Watanabe
 */

@Embeddable
public class MonoId implements Serializable {
    private String model;
    private String modelId;
    private String vendor;
    
    public MonoId() {}
    
    public MonoId(String model, String modelId, String vendor) {
        this.model = model;
        this.modelId = modelId;
        this.vendor = vendor;
    }
    
    public String getHash() {
        return Hash.encrypt(
            getModel() + getModelId() + getVendor(),
            getModelId());
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getModel() != null ? getModel().hashCode() : 0);
        hash += (getModelId() != null ? getModel().hashCode() : 0);
        hash += (getVendor() != null ? getVendor().hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mono)) {
            return false;
        }
        MonoId other = (MonoId) object;
        if (hashCode() != other.hashCode()) {
            return false;
        }
        return true;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }
    
    /**
     * @return the modelId
     */
    public String getModelId() {
        return modelId;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
        return vendor;
    }

}
