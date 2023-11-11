package org.example.base;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

abstract class CrudOperations implements Serializable {
    public abstract EntityManager getEntityManager();
    public abstract void closeConnections();

    public void commitState() {
        getEntityManager().flush();
        closeConnections();
    }

    public <T> T save(T t) {
        t = getEntityManager().merge(t);
        commitState();
        return t;
    }

    public <T> T find(Class entityClass, Object id) {
        return (T) getEntityManager().find(entityClass, id);
    }

    public <T> List<T> getAll(Class<T> entityClass) {
        return getEntityManager().createQuery("from " + entityClass.getSimpleName() + " e").getResultList();
    }

    public void delete(Object delete) {
        getEntityManager().remove(getEntityManager().merge(delete));
        commitState();
    }

    public void delete(Class<?> entityClass, Object primaryKey) {
        Object entityToDelete = getEntityManager().find(entityClass, primaryKey);

        if (entityToDelete != null) {
            getEntityManager().remove(entityToDelete);
            commitState();
        }
    }
}
