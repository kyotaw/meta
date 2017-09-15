/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.murmur.core.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import proto.murmur.core.model.dao.OwnerDao;
import proto.murmur.core.model.entity.Owner;
import proto.murmur.core.model.dto.OwnerDto;
import proto.murmur.core.model.entity.HashedPassword;

/**
 *
 * @author Kyota Watanabe
 */
@Stateless
@LocalBean
public class OwnerService {

    @Inject
    private OwnerDao ownerDao;
    
    public Owner find(String ownerId) {
        return ownerDao.find(ownerId);
    }
    
    public Owner find(OwnerDto dto) {
        Owner owner = ownerDao.find(dto.getOwnerId());
        if (owner == null) {
            return null;
        }
        HashedPassword password = new HashedPassword(dto.getPassword(), dto.getOwnerId());
        if (!owner.getPassword().equals(password)) {
            return null;
        }
        return owner;
    }
    
    public Owner create(OwnerDto dto) throws EntityExistsException {
        Owner owner = ownerDao.find(dto.getOwnerId());
        if (owner != null) {
            return null;
        }
        HashedPassword password = new HashedPassword(dto.getPassword(), dto.getOwnerId());
        owner = new Owner(dto.getOwnerId(), password);
        ownerDao.create(owner);
        return owner;
    }
    
}
