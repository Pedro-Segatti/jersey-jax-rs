package org.example.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CrudService extends CrudOperations {

    private EntityManager entityManager;
    private EntityTransaction transaction;

    @Override
    public EntityManager getEntityManager() {
        if (entityManager == null) {
            this.entityManager = Persistence
                    .createEntityManagerFactory("jersey-jax-rs")
                    .createEntityManager();
            this.transaction = entityManager.getTransaction();
            transaction.begin();
        }
        return entityManager;

    }

    @Override
    public void closeConnections() {
        this.transaction.commit();
        entityManager.clear();
        entityManager.close();
        entityManager = null;
    }
}
