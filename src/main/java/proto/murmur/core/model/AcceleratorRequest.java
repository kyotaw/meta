/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.model;

import proto.murmur.core.model.MonoRequest;
import proto.murmur.core.model.MonoType;

/**
 *
 * @author Kyota Watanabe
 */
public class AcceleratorRequest extends MonoRequest {
    
    public AcceleratorRequest() {
        super(MonoType.Accelerator);
    }
    
}
