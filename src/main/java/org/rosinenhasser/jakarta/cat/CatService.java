package org.rosinenhasser.jakarta.cat;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CatService {
    @PersistenceContext(unitName = "cats")
    private EntityManager em;

    public void create(CatEntity entity) {
        em.persist(entity);
    }

    public CatEntity read(Long id) {
        return em.find(CatEntity.class, id);
    }

    public List<CatEntity> readAll() {
        return em.createQuery("SELECT e FROM CatEntity e", CatEntity.class).getResultList();
    }

    public void update(CatEntity entity) {
        em.merge(entity);
    }

    public void delete(Long id) {
        CatEntity entity = read(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
