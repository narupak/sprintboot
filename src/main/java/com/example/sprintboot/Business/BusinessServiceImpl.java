package com.example.sprintboot.Business;

import com.example.sprintboot.core.PersistenceRepository;
import com.example.sprintboot.core.QueryRepository;
import com.example.sprintboot.entity.*;
import com.example.sprintboot.web.LicenseCarVM;
import com.example.sprintboot.web.RegisterAuctionVM;
import com.example.sprintboot.web.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {
    private static final Logger log = LoggerFactory.getLogger(BusinessService.class);

    private final QueryRepository queryRepository;
    private final PersistenceRepository persistenceRepository;

    public BusinessServiceImpl(QueryRepository queryRepository, PersistenceRepository persistenceRepository) {
        this.queryRepository = queryRepository;
        this.persistenceRepository = persistenceRepository;
    }

    @Override
    public List<User> queryUsers() {
        return queryRepository.quyUsers();
    }

    @Override
    public List<LicenseCars> queryLicenseCar() {
        return queryRepository.queryLicenseCar();
    }

    @Override
    public List<LicenseCarVM> queryLicenseCarByStatus() {
        return queryRepository.queryLicenseCarByStatus();
    }

    @Override
    public List<LicenseCarVM> queryRegisterLicenseCarByStatus() {
        return queryRepository.queryRegisterLicenseCarByStatus();
    }

    @Override
    public void updatestatusLicenseCarByDate(LocalDateTime date) {
        persistenceRepository.updatestatus(date);
    }

    @Override
    public List<LicenseCars> querylicenseCarDetailById(int id) {
        return queryRepository.querylicenseCarDetailById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void registerAuctionLicenseCar(RegisterAuction registerAuction) {
        registerAuction.setUser(queryRepository.find(User.class,registerAuction.getUser().getId()));
        registerAuction.setLicenseCars(queryRepository.find(LicenseCars.class,registerAuction.getLicenseCars().getSeq()));
        registerAuction.setRegisterDate(LocalDate.now());
        persistenceRepository.create(registerAuction,"monai");
    }


    @Override
    public List<RegisterAuction> queryMyAuction(long id) {
        return queryRepository.queryRegisterAuction(id);

    }

    @Override
    public List<RegisterAuction> checkRegisterAuction(long userId, long licenCarId) {
        return queryRepository.checkRegisterAuction(userId,licenCarId);
    }

    @Override
    public List<LicenseCars> queryMemberRegisterAuctionLicenseCar() {
        return queryRepository.queryMemberRegisterAuctionLicenseCar();
    }

    @Override
    public List<RegisterAuction> queryMemberAuction(long id) {
        return queryRepository.queryMemberAuction(id);
    }

    @Override
    public LocalDateTime queryCurrentTimestamp() {
        return queryRepository.queryCurrentTimestamp();
    }

    @Override
    public void updateStatusLicenseCar(long licenseCarId) {
        persistenceRepository.updateStatusLicenseCar(licenseCarId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertSaveAuction(SaveAuction saveAuction) {
        persistenceRepository.create(saveAuction,"OnepiecEz");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insertHistory(List<HistoryAuction> history) {
        persistenceRepository.insertHistory(history);
    }

    @Override
    public List<SaveAuction> querySaveAuctionByLicenseCarId(long licenseCarId) {
        return queryRepository.querySaveAuctionByLicenseCarId(licenseCarId);
    }

    @Override
    public List<HistoryAuction> queryHistoryAuctionByLicenseCarId(long licenseCarId) {
        return queryRepository.queryHistoryAuctionByLiceseCarId(licenseCarId);
    }

    @Override
    public Long checkStatusLicenseCarByLicenseCarId(long licenseCarId) {
        return queryRepository.checkStatusLicenseCarByLicenseCarId(licenseCarId);
    }

    @Override
    public Long queryCountRegisterAuction(long licenseCarId) {
        return queryRepository.querycountRegisterAuction(licenseCarId);
    }

    @Override
    public List<Integer> queryHistoryAuctionByUserId(long userId) {
        return queryRepository.queryHistoryAuctionByUserId(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert(User user) {
        persistenceRepository.create(user,"monai");
    }

    @Override
    public List<User> checkAuthentication(String username,String password,long id) {
        return queryRepository.checkAuthentication(username,password,id);
    }



}
