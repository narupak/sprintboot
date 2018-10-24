package com.example.sprintboot.core;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public abstract class CoreQueryRepository {
    protected abstract EntityManager getEntityManager();
    public <T, ID> T find(Class<T> clazz, ID primaryKey){
        return this.getEntityManager().find(clazz,primaryKey);
    }
}
