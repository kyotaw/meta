/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.controller;

import java.math.BigDecimal;
import proto.meta.core.connect.SuccessResponse;
import proto.meta.core.connect.JSON;
import proto.meta.core.model.entity.Mono;
import proto.meta.core.model.entity.MonoId;

/**
 *
 * @author Kyota Watanabe
 */
public class MonoResponse extends SuccessResponse {
    private final Mono mono;
    
    public MonoResponse(Mono mono) {
        this.mono = mono;
    }
    
    @Override
    public JSON toJson() {
        JSON json = super.toJson();
        MonoId id = mono.getMonoId();
        JSON monoJson = new JSON();
        monoJson
            .add("name", mono.getName())
            .add("model", id.getModel())
            .add("modelId", id.getModelId())
            .add("vendor", id.getVendor())
            .add("hash", mono.getHash());
        json.add("mono", monoJson);
        return json;
    }
    
    @Override
    public String toString() {
        return toJson().toString();
    }
}
