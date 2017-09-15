/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.controller;

import proto.murmur.core.connect.JSON;
import proto.murmur.core.connect.SuccessResponse;
import proto.murmur.core.model.entity.Owner;

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
