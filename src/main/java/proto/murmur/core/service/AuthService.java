/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import proto.murmur.core.model.dto.OwnerDto;
import proto.murmur.core.model.entity.Owner;

/**
 *
 * @author Kyota Watanabe
 */
@Stateless
@LocalBean
public class AuthService {

    @Inject OwnerService ownerService; 
    
    public Owner login(OwnerDto dto, HttpServletRequest req) {
        Owner owner = ownerService.find(dto);
        if (owner == null) {
            return null;
        }
        
        HttpSession session = req.getSession(true);
        req.changeSessionId();
        session.setAttribute("ownerId", owner.getOwnerId());
        return owner;
    }
    
    public boolean isAuthenticated(HttpServletRequest req) {
        if (req.getPathInfo() == "login") {
            return true;
        }
        HttpSession session = req.getSession();
        return (session != null) && session.getAttribute("ownerId") != null;
    }
}
