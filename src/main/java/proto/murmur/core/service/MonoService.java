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

import proto.murmur.core.model.dao.MonoDao;
import proto.murmur.core.model.dto.NewMonoDto;
import proto.murmur.core.model.entity.MonoId;
import proto.murmur.core.model.entity.Mono;

/**
 *
 * @author Kyota Watanabe
 */
@Stateless
@LocalBean
public class MonoService {
 
    @Inject
    private MonoDao monoDao;
    
    public Mono find(String model, String modelId, String vendor) {
        MonoId id = new MonoId(model, modelId, vendor);
        return monoDao.find(id);
    }
    public Mono find(MonoId id) {
        return monoDao.find(id);
    }

    public Mono register(NewMonoDto dto) throws EntityExistsException {
        MonoId id = new MonoId(dto.getModel(), dto.getModelId(), dto.getVendor());
        Mono mono = find(id);
        if (mono != null) {
            return null;
            //throw new EntityExistsException();
        }
        mono = new Mono(id, dto.getName());
        monoDao.create(mono);
        return mono;
    }
    
}
