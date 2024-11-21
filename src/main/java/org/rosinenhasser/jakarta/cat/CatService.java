package org.rosinenhasser.jakarta.cat;

import jakarta.annotation.Nullable;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class CatService {
    @Nullable
    @PersistenceContext(unitName = "cats")
    private EntityManager em;

    public void create(CatEntity entity) {
        if (em != null) {
            em.persist(entity);
        }
    }

    public CatEntity read(Long id) {
        if (em != null) {
            return em.find(CatEntity.class, id);
        } else {
            throw new IllegalArgumentException("EntityManager ist null");
        }
    }

    public List<CatEntity> readAll() {
        if (em != null) {
            return em.createQuery("SELECT e FROM CatEntity e", CatEntity.class).getResultList();
        } else {
            throw new IllegalArgumentException("EntityManager ist null");
        }
    }

    public void update(CatEntity entity) {
        if (em != null) {
            em.merge(entity);
        }
    }

    public void delete(Long id) {
        CatEntity entity = read(id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
