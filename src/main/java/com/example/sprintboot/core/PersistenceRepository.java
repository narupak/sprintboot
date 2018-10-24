package com.example.sprintboot.core;

import com.example.sprintboot.entity.HistoryAuction;
import com.example.sprintboot.entity.LicenseCars;
import com.example.sprintboot.entity.User;
import com.example.sprintboot.entity.Winner;
import com.example.sprintboot.web.UserVM;

import java.time.LocalDateTime;
import java.util.List;

public abstract class PersistenceRepository extends CorePersistenceRepository {

    //public abstract int deleteSuspectedList(String SuspectedSeq, String imgCat);

    //public abstract int deleteSuspectedPv(String seq);

    //public abstract int updateExpireTime(String userId);
    public abstract void insert(UserVM user);
    public abstract void updatestatus(LocalDateTime date);
    public abstract void updateStatusLicenseCar(long licenseCarId);
    public abstract void insertSaveAuction(Winner winner);
    public abstract void insertHistory(List<HistoryAuction> history);
}
