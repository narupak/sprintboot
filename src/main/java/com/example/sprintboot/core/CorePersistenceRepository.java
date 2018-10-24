package com.example.sprintboot.core;

import com.example.sprintboot.entity.FwEntity;
import org.hibernate.StaleObjectStateException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//import th.go.immigration.sps.model.entity.core.FwEntity;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

public abstract class CorePersistenceRepository{

    protected abstract EntityManager getEntityManager();

    /**
     * this method will generated CREATE_DATE, CREATE_BY
     *
     * @param entity   data to insert
     * @param createBy creating user
     * @param <T>      {@code entity2} must inherits from {@link com.example.sprintboot.entity.FwEntity}
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public <T extends FwEntity> T create(T entity, String createBy) {
        entity.setCreateDate(LocalDateTime.now());
        entity.setCreateBy(createBy);

        this.getEntityManager().persist(entity);
        return entity;
    }

    /**
     * this method will generated UPDATE_DATE, UPDATE_BY <BR />
     * and if not exist CREATE_DATE, CREATE_BY that will also generated here.
     *
     * @param entity   data to insert/update
     * @param updateBy updating user
     * @param <T>      {@code entity2} must inherits from {@link com.example.sprintboot.entity.FwEntity}
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public <T extends FwEntity> T createOrUpdate(T entity, String updateBy) throws StaleObjectStateException {
        LocalDateTime now = LocalDateTime.now();
        if (null == entity.getCreateBy() && null == entity.getCreateDate()) {
            entity.setCreateBy(updateBy);
            entity.setCreateDate(now);
        }

        entity.setUpdateBy(updateBy);
        entity.setUpdateDate(now);

        T mergedEntity = this.getEntityManager().merge(entity);

        return mergedEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T create(T entity) {
        this.getEntityManager().persist(entity);
        return entity;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public <T> T createOrUpdate(T entity) {
        return this.getEntityManager().merge(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public <T> void remove(T entity) {
        this.getEntityManager().remove(entity);
    }

}