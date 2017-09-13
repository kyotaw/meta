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

import proto.meta.core.model.entity.Owner;
import proto.meta.core.model.entity.Owner_;
import proto.meta.core.model.entity.HashedPassword;

/**
 *
 * @author Kyota Watanabe
 */
@Stateless
public class OwnerDao extends AbstractFacade<Owner> {

    @PersistenceContext(unitName = "META-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OwnerDao() {
        super(Owner.class);
    }
    
    public Owner find(String ownerId) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Owner> cq = cb.createQuery(Owner.class);
        Root<Owner> root = cq.from(Owner.class);
        cq.select(root)
          .where(cb.like(root.get(Owner_.ownerId), ownerId));
        
        List<Owner> list = em.createQuery(cq).getResultList();
        return list.isEmpty() ? null : list.get(0);
    }
  
}
