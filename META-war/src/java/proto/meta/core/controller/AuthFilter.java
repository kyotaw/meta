/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.controller;

import java.io.IOException;
import javax.inject.Inject;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import proto.meta.core.service.AuthService;

/**
 *
 * @author Kyota Watanabe
 */

@Priority(Priorities.AUTHENTICATION)
//@Provider
public class AuthFilter implements ContainerRequestFilter {
    
    @Context
    private HttpServletRequest req;
    
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = req.getPathInfo();
        if (!path.equals("/owners/login") && !path.equals("/owners")) {
            HttpSession session = req.getSession();
            if ((session == null) || (session.getAttribute("ownerId") == null)) {
                requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
            }
        }
    }
}
