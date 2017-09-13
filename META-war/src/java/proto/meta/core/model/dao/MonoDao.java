/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proto.meta.core.model.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import proto.meta.core.model.entity.Mono;
import proto.meta.core.model.entity.Mono_;
import proto.meta.core.model.entity.MonoId;

/**
 *
 * @author Kyota Watanabe
 */
@Stateless
public class MonoDao extends AbstractFacade<Mono> {

    @PersistenceContext(unitName = "META-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MonoDao() {
        super(Mono.class);
    }
    
    public Mono find(MonoId monoId) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Mono> cq = cb.createQuery(Mono.class);
        Root<Mono> root = cq.from(Mono.class);
        cq.select(root)
          .where(cb.like(root.get(Mono_.hash), monoId.getHash()));
        
        List<Mono> list = em.createQuery(cq).getResultList();
        return list.isEmpty() ? null : list.get(0);
    } 
    
}
