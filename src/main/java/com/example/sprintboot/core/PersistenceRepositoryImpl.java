package com.example.sprintboot.core;

import com.example.sprintboot.entity.HistoryAuction;
import com.example.sprintboot.entity.LicenseCars;
import com.example.sprintboot.entity.User;
import com.example.sprintboot.entity.Winner;
import com.example.sprintboot.web.UserVM;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PersistenceRepositoryImpl extends PersistenceRepository{

    @PersistenceContext
    protected EntityManager entityManager;
    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert(UserVM userVM) {

        User users = new User();
        users.setUsername(userVM.getUsername());
        users.setPassword(userVM.getPassword());
        users.setFirstname(userVM.getFirstname());
        users.setLastname(userVM.getLastname());
        users.setTel(userVM.getTel());
        users.setMail(userVM.getMail());
        entityManager.persist(users);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updatestatus(LocalDateTime today) {
        String sql = "UPDATE license_cars " +
                        " SET status = 2 " +
                        " WHERE auction_date <= ? AND status= '1'";
        Query query = entityManager.createNativeQuery(sql, LicenseCars.class);
        query.setParameter(1,today);
        query.executeUpdate();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStatusLicenseCar(long licenseCarId) {
        String sql = "UPDATE license_cars SET status = 3 WHERE seq = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,licenseCarId);
        query.executeUpdate();
    }

    @Override
    public void insertSaveAuction(Winner winner) {
        entityManager.persist(winner);
    }

    @Override
    public void insertHistory(List<HistoryAuction> history) {
        for(HistoryAuction historyAuction : history){
            entityManager.persist(historyAuction);
        }
    }
}
