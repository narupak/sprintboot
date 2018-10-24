package com.example.sprintboot.core;

import com.example.sprintboot.entity.*;
import com.example.sprintboot.web.LicenseCarVM;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public abstract class QueryRepository extends CoreQueryRepository{
    public abstract List<User> quyUsers();
    public abstract List<LicenseCars> queryLicenseCar();
    public abstract List<LicenseCarVM> queryLicenseCarByStatus();
    public abstract List<LicenseCarVM> queryRegisterLicenseCarByStatus();
    public abstract List<User> checkAuthentication(String username,String password,long id);
    public abstract List<LicenseCars> querylicenseCarDetailById(int id);
    public abstract List<RegisterAuction> queryRegisterAuction(long id);
    public abstract List<RegisterAuction> checkRegisterAuction(long userId,long licenseCararId);
    public abstract List<LicenseCars> queryMemberRegisterAuctionLicenseCar();
    public abstract List<RegisterAuction> queryMemberAuction(long id);
    public abstract LocalDateTime queryCurrentTimestamp();
    public abstract List<Integer> queryHistoryAuctionByUserId(long userId);
    public abstract List<SaveAuction> querySaveAuctionByLicenseCarId(long licenseCarId);
    public abstract List<HistoryAuction> queryHistoryAuctionByLiceseCarId(long licenseCarId);
    public abstract Long checkStatusLicenseCarByLicenseCarId(long licenseCarId);
    public abstract Long querycountRegisterAuction(long licenseCarId);
}
