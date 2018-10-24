package com.example.sprintboot.core;

import com.example.sprintboot.entity.*;
import com.example.sprintboot.web.LicenseCarVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.imageio.spi.RegisterableService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QueryRepositoryImpl extends QueryRepository {

    private static final Logger log = LoggerFactory.getLogger(QueryRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    //@Autowired
    //private PersistenceContext

    @Override
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public List<User> quyUsers() {
        String sql = "SELECT * FROM user";
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createNativeQuery(sql, User.class);
        List<User> userList = query.getResultList();
        return userList;
    }

    @Override
    public List<LicenseCars> queryLicenseCar() {
        String sql = "SELECT * FROM license_cars";
        TypedQuery<LicenseCars> query = (TypedQuery<LicenseCars>) entityManager.createNativeQuery(sql, LicenseCars.class);
        List<LicenseCars> licenseCarList = query.getResultList();
        return licenseCarList;
    }

    @Override
    public List<LicenseCarVM> queryLicenseCarByStatus() {
        StringBuilder sql = new StringBuilder("SELECT * FROM license_cars WHERE status = ?");
        Query query = entityManager.createNativeQuery(sql.toString(), LicenseCars.class);
        query.setParameter(1, '2');
        List<LicenseCars> licenseCarsList = query.getResultList();
        List<LicenseCarVM> licenseCarVMList = new ArrayList<LicenseCarVM>();
        for (LicenseCars licenseCar: licenseCarsList) {
            LicenseCarVM licenseCarVM = new LicenseCarVM();
            licenseCarVM.setNumber(licenseCar.getNumber());
            licenseCarVM.setSeq(licenseCar.getSeq());
            licenseCarVM.setImageLicenseCar(licenseCar.getImageLicenseCar());
            licenseCarVM.setFirstprice(licenseCar.getFirstprice());
            licenseCarVM.setStatus(licenseCar.getStatus());
            licenseCarVMList.add(licenseCarVM);
        }

        return licenseCarVMList;
    }

    @Override
    public List<LicenseCarVM> queryRegisterLicenseCarByStatus() {
        StringBuilder sql = new StringBuilder("SELECT * FROM license_cars WHERE status = ?");
        Query query = entityManager.createNativeQuery(sql.toString(), LicenseCars.class);
        query.setParameter(1, '1');
        List<LicenseCars> regislicenseCarsList = query.getResultList();
        List<LicenseCarVM> ListlicenseCarVM = new ArrayList<LicenseCarVM>();
        for (LicenseCars licenseCar: regislicenseCarsList) {
            LicenseCarVM licenseCarVM = new LicenseCarVM();
            licenseCarVM.setNumber(licenseCar.getNumber());
            licenseCarVM.setSeq(licenseCar.getSeq());
            licenseCarVM.setImageLicenseCar(licenseCar.getImageLicenseCar());
            licenseCarVM.setStatus(licenseCar.getStatus());
            ListlicenseCarVM.add(licenseCarVM);
        }
        return ListlicenseCarVM;
    }

    @Override
    public List<User> checkAuthentication(String username, String password,long id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user");
        if(username != null && password != null) {
            sql.append(" WHERE username = :username AND password = :password");
        }else{
            sql.append(" WHERE id = :id");
        }
        Query query = entityManager.createNativeQuery(sql.toString(),User.class);
        if(username != null && password != null) {
            query.setParameter("username",username);
            query.setParameter("password",password);
        }else{
            query.setParameter("id",id);
        }
        List<User> Listuser = query.getResultList();
        return Listuser;
    }

    @Override
    public List<LicenseCars> querylicenseCarDetailById(int id) {
        StringBuilder sql = new StringBuilder("SELECT * FROM license_cars WHERE seq = :id");
        Query query = entityManager.createNativeQuery(sql.toString(),LicenseCars.class);
        query.setParameter("id",id);
        List<LicenseCars> LicenseDetail = query.getResultList();
        return LicenseDetail;
    }
//
//    @Override
//    public List<RegisterAuction> queryRegisterAuction(int id) {
//        return null;
//    }

    @Override
    public List<RegisterAuction> queryRegisterAuction(long id) {
        StringBuilder jpql = new StringBuilder("select rg FROM RegisterAuction rg WHERE rg.user.id = :id");
        Query query = entityManager.createQuery(jpql.toString());
        query.setParameter("id",Long.valueOf(id));
        List<RegisterAuction> regisList = query.getResultList();
        return regisList;
    }

    @Override
    public List<RegisterAuction> checkRegisterAuction(long userId, long licenseCararId) {
        StringBuilder sql = new StringBuilder("select *from register_auction WHERE  user_id = ? AND license_car_id = ?");
        Query query = entityManager.createNativeQuery(sql.toString(),RegisterAuction.class);
        query.setParameter(1,userId);
        query.setParameter(2,licenseCararId);
        List<RegisterAuction> checkregList= query.getResultList();
        return checkregList;
    }

    @Override
    public List<LicenseCars> queryMemberRegisterAuctionLicenseCar() {
        StringBuilder sql = new StringBuilder("select * from license_cars where status = '2'");
        Query query = entityManager.createNativeQuery(sql.toString(),LicenseCars.class);
        List<LicenseCars> registerList = query.getResultList();
        return registerList;
    }

    @Override
    public List<RegisterAuction> queryMemberAuction(long id) {
        StringBuilder sql = new StringBuilder("select * from register_auction where license_car_id = ?");
        Query query = entityManager.createNativeQuery(sql.toString(),RegisterAuction.class);
        query.setParameter(1,id);
        List<RegisterAuction> memberRegisterAuctionsList = query.getResultList();
        return memberRegisterAuctionsList;
    }

    @Override
    public LocalDateTime queryCurrentTimestamp() {
        StringBuilder sql = new StringBuilder("SELECT CURRENT_TIMESTAMP");
        Query query = entityManager.createNativeQuery(sql.toString());
        Timestamp currentTime = Timestamp.valueOf(query.getSingleResult().toString());
        LocalDateTime dateTime = currentTime.toLocalDateTime();
        return dateTime;
    }

    @Override
    public List<Integer> queryHistoryAuctionByUserId(long userId) {
        String sql = "select distinct license_car_id from history_auction where user_id = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,userId);
        List<Integer> historyList = query.getResultList();
        return historyList;
    }

    @Override
    public List<SaveAuction> querySaveAuctionByLicenseCarId(long licenseCarId) {
        StringBuilder jpql = new StringBuilder("select sa FROM SaveAuction sa WHERE sa.licenseCars.seq = :licenseCarId");
        Query query = entityManager.createQuery(jpql.toString());
        query.setParameter("licenseCarId",licenseCarId);
        List<SaveAuction> saveAuctionList = query.getResultList();
        return saveAuctionList;
    }

    @Override
    public List<HistoryAuction> queryHistoryAuctionByLiceseCarId(long licenseCarId) {
        StringBuilder jpql = new StringBuilder("select ha from HistoryAuction ha where ha.licenseCarId = :licenseCarId");
        Query query = entityManager.createQuery(jpql.toString(),HistoryAuction.class);
        query.setParameter("licenseCarId",licenseCarId);
        List<HistoryAuction> historyAuction = query.getResultList();
        return historyAuction;
    }

    @Override
    public Long checkStatusLicenseCarByLicenseCarId(long licenseCarId) {
        String sql = "select status from license_cars where seq = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,licenseCarId);
        Long statusResult = Long.valueOf((String) query.getSingleResult());
        return statusResult;
    }

    @Override
    public Long querycountRegisterAuction(long licenseCarId) {
        String sql = "select count(seq) from register_auction where license_car_id = ?";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1,licenseCarId);
        Long amountRegister = Long.valueOf(query.getSingleResult().toString());
        return amountRegister;
    }


}
