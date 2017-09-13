/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.controller;

import proto.meta.core.connect.JSON;
import proto.meta.core.connect.SuccessResponse;
import proto.meta.core.model.entity.Owner;

/**
 *
 * @author Kyota Watanabe
 */
public class OwnerResponse extends SuccessResponse {
    private final Owner owner;
    
    public OwnerResponse(Owner owner) {
        this.owner = owner;
    }
    
    @Override
    public JSON toJson() {
        JSON json = super.toJson();
        JSON ownerJson = new JSON();
        ownerJson.add("ownerId", owner.getOwnerId());
        json.add("owner", ownerJson);
        return json;
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
}
