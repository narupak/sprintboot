package com.example.sprintboot.Business;

import com.example.sprintboot.entity.*;
import com.example.sprintboot.web.LicenseCarVM;
import java.time.LocalDateTime;
import java.util.List;

public interface BusinessService {
    List<User> queryUsers();
    List<LicenseCars> queryLicenseCar();
    List<LicenseCarVM> queryLicenseCarByStatus();
    List<LicenseCarVM> queryRegisterLicenseCarByStatus();
    void insert(User user);
    List<User> checkAuthentication(String username,String password,long id);
    void updatestatusLicenseCarByDate(LocalDateTime date);
    List<LicenseCars> querylicenseCarDetailById(int id);
    void registerAuctionLicenseCar(RegisterAuction registerAuction);
    List<RegisterAuction> queryMyAuction(long id);
    List<RegisterAuction> checkRegisterAuction(long userId,long licenCarId);
    List<LicenseCars> queryMemberRegisterAuctionLicenseCar();
    List<RegisterAuction> queryMemberAuction(long id);
    LocalDateTime queryCurrentTimestamp();
    void updateStatusLicenseCar(long licenseCarId);
    void insertSaveAuction(SaveAuction saveAuction);
    void insertHistory(List<HistoryAuction> history);
    List<Integer> queryHistoryAuctionByUserId(long userId);
    List<SaveAuction> querySaveAuctionByLicenseCarId(long licenseCarId);
    List<HistoryAuction> queryHistoryAuctionByLicenseCarId(long licenseCarId);
    Long checkStatusLicenseCarByLicenseCarId(long licenseCarId);
    Long queryCountRegisterAuction(long licenseCarId);
}
