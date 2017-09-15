/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.connect;

import proto.murmur.core.connect.JSON;

/**
 *
 * @author Kyota Watanabe
 */
public interface Response {
    public JSON toJson();
}
