package com.example.sprintboot.web;

import com.example.sprintboot.Business.BusinessService;
import com.example.sprintboot.GenericRequest;
import com.example.sprintboot.GenericResponse;
import com.example.sprintboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@RestController
public class ServiceController {

    @Autowired
    BusinessService service;

    ControllerData controldata = ControllerData.getInstance();

    @RequestMapping("/data")
    public ResponseEntity data() {
        try {
            GenericResponse<Response> responseData = new GenericResponse<>();
            Response res = new Response("success", "query complete");
            //responseData.setMessage(res.toString());
            //responseData.setResults(service.queryUsers());
            return ResponseEntity.ok().body(service.queryUsers());
        } catch (Exception e) {
            e.printStackTrace();
            Response res = new Response("failed", "query failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody GenericRequest<UserVM> genericRequest) {
        //List<User> users = new ArrayList<>();
        UserVM uservm = genericRequest.getRequest();
        User users = new User();
        users.setUsername(uservm.getUsername());
        users.setPassword(uservm.getPassword());
        users.setFirstname(uservm.getFirstname());
        users.setLastname(uservm.getLastname());
        users.setAddress(uservm.getAddress());
        users.setTel(uservm.getTel());
        users.setMail(uservm.getMail());
        GenericResponse<Response> responseData = new GenericResponse<>();
        LocalDateTime date = LocalDateTime.now();
//        User users = new User("monai123",date,"monai","Talwat","monai@hotmail.com","123456789","05184948","monai",date,"monai123");
        service.insert(users);
        try {
            Response response = new Response("success", "insert complete");
            //responseData.setResult();
            responseData.setMessage("insert complete");
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            e.printStackTrace();
            Response response = new Response("failed", "insert failed");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
    @PostMapping("/checkAuthen")
    public ResponseEntity checkAuthen(@RequestBody GenericRequest<UserVM> genericRequest) {
        UserVM uservm = genericRequest.getRequest();
        List<User> userList = service.checkAuthentication(uservm.getUsername(),uservm.getPassword(),uservm.getId());
        if(userList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(userList);
        }
    }

    @GetMapping("/licenseCar")
    public ResponseEntity queryLicenseCar() {
        //GenericResponse<Response> responseData = new GenericResponse<>();
        List<LicenseCarVM> carsList = service.queryLicenseCarByStatus();
//        for (LicenseCars list: carsList) {
//            LocalDate auction_date = list.getAuctionDate().toLocalDate();
//            long dateTime = auction_date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
//            //list.setAuctionDate(dateTime);
//        }
        if(carsList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(carsList);
        }
    }

    @GetMapping("/registerLicenseCar")
    public ResponseEntity queryRegisterLicenseCar() {
        //GenericResponse<Response> responseData = new GenericResponse<>();
        List<LicenseCarVM> carsList = service.queryRegisterLicenseCarByStatus();
        if(carsList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(carsList);
        }
    }


    @GetMapping("/updateLicenseCar")
    public ResponseEntity updateLicenseCar(@RequestParam(value = "auction_date") long date) {
        //LocalDate time = Instant.ofEpochMilli(date).atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDateTime triggerTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                TimeZone.getDefault().toZoneId());
        service.updatestatusLicenseCarByDate(triggerTime);
        GenericResponse<Response> responseData = new GenericResponse<>();
        responseData.setMessage("success");
        return ResponseEntity.ok().body(responseData);
    }



    @GetMapping("/queryLicenseCarDetailById")
    public ResponseEntity querylicenseCarDetailById(@RequestParam(value = "licenseCarId") int licenseCarId){
        //List<LicenseCars> licenseCarList = service.
        List<LicenseCars> carsList = service.querylicenseCarDetailById(licenseCarId);
        List<LicenseCarVM> carListVM = new ArrayList<>();
        for (LicenseCars list: carsList) {
            LocalDate auctionDate = list.getAuctionDate().toLocalDate();
            LocalDate startRegisterDate = list.getStartRegisterDate();
            LocalDate endRegisterDate = list.getEndRegisterDate();
            long dateTime = auctionDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            long startDateTime = startRegisterDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            long endDateTime = endRegisterDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();

            LicenseCarVM licenseCarVM = new LicenseCarVM();

            licenseCarVM.setAcutionDate(dateTime);
            licenseCarVM.setNumber(list.getNumber());
            licenseCarVM.setImageLicenseCar(list.getImageLicenseCar());
            licenseCarVM.setFirstprice(list.getFirstprice());
            licenseCarVM.setAuctionTime(list.getAuctionTime());
            licenseCarVM.setStartRegisterDate(startDateTime);
            licenseCarVM.setEndRegisterDate(endDateTime);
            carListVM.add(licenseCarVM);
        }
        if(carsList.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(carListVM);
        }
    }

        @PostMapping("/registerAuctionLicenseCar")
    public ResponseEntity registerAuctionLicenseCar(@RequestBody GenericRequest<RegisterAuctionVM> genericRequest){
        RegisterAuctionVM registerAuctionVM = genericRequest.getRequest();

        RegisterAuction registerAuction = new RegisterAuction();
        LicenseCars license = new LicenseCars();
        license.setSeq((long) registerAuctionVM.getLicenseCarId());
        registerAuction.setLicenseCars(license);
        User user = new User();
        user.setId((long) registerAuctionVM.getUserId());
        registerAuction.setUser(user);
        registerAuction.setRegisterDate(registerAuctionVM.getRegisterDate());
            if(registerAuction == null) {
                Response response = new Response("failed", "registerAuctionLicenseCar failed");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }else{
                service.registerAuctionLicenseCar(registerAuction);
                Response response = new Response("success", "registerAuctionLicenseCar Complete");
                return ResponseEntity.ok().body(response);
            }
    }

    @PostMapping("/queryMyAuction")
    public ResponseEntity queryMyAuction(@RequestBody GenericRequest<RegisterAuctionVM> genericRequest){
        RegisterAuctionVM registerAuctionVM = genericRequest.getRequest();
        List<RegisterAuction> regisList = service.queryMyAuction(registerAuctionVM.getUserId());
        List<LicenseCarVM> carListVM = new ArrayList<>();
        List<RegisterAuctionVM> ListregisterAuctionvm = new ArrayList<>();
        for (RegisterAuction list: regisList) {
            LicenseCars licenseCar = list.getLicenseCars();
            LocalDate auctionDate = licenseCar.getAuctionDate().toLocalDate();
            LocalDate startRegisterDate = licenseCar.getStartRegisterDate();
            LocalDate endRegisterDate = licenseCar.getEndRegisterDate();
            //LocalDate createDate = licenseCar.getCreateDate();
            long dateTime = auctionDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            long startDateTime = startRegisterDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            long endDateTime = endRegisterDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            //long createDateTime = createBy.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
            LicenseCarVM licenseCarVM = new LicenseCarVM();

            licenseCarVM.setSeq(list.getLicenseCars().getSeq());
            licenseCarVM.setAcutionDate(dateTime);
            licenseCarVM.setNumber(licenseCar.getNumber());
            licenseCarVM.setImageLicenseCar(licenseCar.getImageLicenseCar());
            licenseCarVM.setFirstprice(licenseCar.getFirstprice());
            licenseCarVM.setAuctionTime(licenseCar.getAuctionTime());
            licenseCarVM.setStartRegisterDate(startDateTime);
            licenseCarVM.setEndRegisterDate(endDateTime);
            licenseCarVM.setStatus(licenseCar.getStatus());
            //licenseCarVM.setCreateBy(createDateTime);
            //carListVM.add(licenseCarVM);
            User user = list.getUser();
            UserVM userVM = new UserVM();
            userVM.setId(user.getId());
            userVM.setUsername(user.getUsername());
            userVM.setPassword(user.getPassword());
            userVM.setFirstname(user.getFirstname());
            userVM.setLastname(user.getLastname());
            userVM.setAddress(user.getAddress());
            userVM.setTel(user.getTel());
            userVM.setMail(user.getMail());

            RegisterAuctionVM registerAuctionvm = new RegisterAuctionVM();
            registerAuctionvm.setSeq(list.getSeq());
            registerAuctionvm.setUserId(user.getId());
            registerAuctionvm.setLicenseCarId(licenseCar.getSeq());
            registerAuctionvm.setLicenseCarVM(licenseCarVM);
            registerAuctionvm.setRegisterDate(list.getRegisterDate());
            registerAuctionvm.setUserVM(userVM);

            ListregisterAuctionvm.add(registerAuctionvm);

        }

        if(ListregisterAuctionvm.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(ListregisterAuctionvm);
        }
    }

    @PostMapping("/checkRegisterAuction")
    public ResponseEntity checkRegisterAuction(@RequestBody GenericRequest<RegisterAuctionVM> genericRequest){
        RegisterAuctionVM registerAuction = genericRequest.getRequest();
        LicenseCarVM licenseCars = registerAuction.getLicenseCarVM();
        long licenseCarsSeq = licenseCars.getSeq();
        UserVM user = registerAuction.getUserVM();
        long userId = user.getId();
        List<RegisterAuction> regisList = service.checkRegisterAuction(userId,licenseCarsSeq);
        List<RegisterAuctionVM> registerAuctionVMList = new ArrayList<>();
        for (RegisterAuction regis: regisList) {
            RegisterAuctionVM registerAuctionVM = new RegisterAuctionVM();
            UserVM users = new UserVM();
            users.setId(regis.getUser().getId());
            LicenseCarVM licenseCarVM = new LicenseCarVM();
            licenseCarVM.setSeq(regis.getLicenseCars().getSeq());
            registerAuctionVM.setUserId(regis.getSeq());
            registerAuctionVM.setRegisterDate(regis.getRegisterDate());
            registerAuctionVM.setUserVM(users);
            registerAuctionVM.setLicenseCarVM(licenseCarVM);
            registerAuctionVMList.add(registerAuctionVM);
        }
        if (registerAuctionVMList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(registerAuctionVMList);
        }

    }
    @GetMapping("queryMemberRegisterAuctionLicenseCar")
    public ResponseEntity queryMemberRegisterAuctionLicenseCar(){
        List<LicenseCars> registerMemberList = service.queryMemberRegisterAuctionLicenseCar();
        List<MemberAuction> registermemberListVM = new ArrayList<>();
        long tempLicenseId = 1;

        /////////////////////////////loop for license Car///////////////////////////////////
        for ( LicenseCars licenseCars: registerMemberList) {
            List<UserVM> memberLists = new ArrayList<>();
            MemberAuction registerVM = new MemberAuction();
            //registerVM.setLicenseCarId(licenCars.getSeq());
            LicenseCarVM licenseCarVM = new LicenseCarVM();
            licenseCarVM.setSeq(licenseCars.getSeq());
            licenseCarVM.setAuctionTime(licenseCars.getAuctionTime());
            licenseCarVM.setFirstprice(licenseCars.getFirstprice());

            long id = licenseCars.getSeq();
            List<RegisterAuction> member = service.queryMemberAuction(id);
            ///////////////////////////////// loop for member//////////////////////////////////
            for(RegisterAuction memberList : member){
                UserVM userVM = new UserVM();
                userVM.setId(memberList.getUser().getId());
                memberLists.add(userVM);
            }
            ///////////////////////////////// loop for member//////////////////////////////////

            registerVM.setLicenseCarVM(licenseCarVM);
            registerVM.setUserVM(memberLists);
            registermemberListVM.add(registerVM);
        }

        /////////////////////////////lopp for license Car///////////////////////////////////
        if(registermemberListVM.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(new GenericResponse<>(registermemberListVM));
        }
    }

    @GetMapping("getCurrentTimeStamp")
    public ResponseEntity queryCurrentTimeStamp(){
        //LocalDate createDate = licenseCar.getCreateDate();
        ZoneId zoneId = ZoneId.systemDefault(); // or: ZoneId.of("Europe/Oslo");
        LocalDateTime date = LocalDateTime.now();
        long epoch = date.atZone(zoneId).toEpochSecond()*1000;
        return ResponseEntity.ok().body(epoch);
    }

    @PostMapping("updateStatusLicenseCar")
    public ResponseEntity updateStatusLicenseCar(@RequestParam(value = "licenseCarId") long licenseCarId ){
        service.updateStatusLicenseCar(licenseCarId);
        GenericResponse<Response> responseData = new GenericResponse<>();
        responseData.setMessage("success");
        return ResponseEntity.ok().body(responseData);
    }

    @PostMapping("insertSaveAuction")
    public ResponseEntity insertSaveAuction(@RequestBody GenericRequest<Winner> genericRequestWinner){
        Winner winnerReq = genericRequestWinner.getRequest();
        SaveAuction saveAuction = new SaveAuction();
        saveAuction.getUser().setId(winnerReq.getBidder());
        LocalDateTime date = Instant.ofEpochMilli(winnerReq.getBidTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
        saveAuction.setEndAuctionDate(date);
        saveAuction.setFinalprice(winnerReq.getPrice());
        saveAuction.getLicenseCars().setSeq(winnerReq.getLicenseCarId());
        service.insertSaveAuction(saveAuction);
        GenericResponse<Response> responseData = new GenericResponse<>();
        responseData.setMessage("success");
        return ResponseEntity.ok().body(responseData);
    }

    @PostMapping("insertHistory")
    public ResponseEntity saveHistory(@RequestBody GenericRequest<SaveHistoryViewModel> genericRequestHistory){
        List<HistoryAuction> historyList = new ArrayList();
        List<SaveHistoryViewModel> historyRequest = genericRequestHistory.getRequests();
        for(SaveHistoryViewModel history : historyRequest){
            HistoryAuction historyAuction = new HistoryAuction();
            User user = new User();
            user.setId(history.getId());
            historyAuction.setUser(user);
            Long date = Long.valueOf(history.getDate());
            LocalDateTime auctionTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date),
                    TimeZone.getDefault().toZoneId());
            historyAuction.setAuctionTime(auctionTime);
            historyAuction.setAuctionPrice(history.getPrice());
            historyAuction.setLicenseCarId(history.getLicenseCarId());
            historyList.add(historyAuction);
        }
        service.insertHistory(historyList);
        GenericResponse<Response> responseData = new GenericResponse<>();
        responseData.setMessage("success");
        return ResponseEntity.ok().body(responseData);
    }

    @PostMapping("queryHistoryAuctionByUserId")
    public ResponseEntity queryHistoryAution(@RequestParam(value = "userId") long userId) {
        List<SaveAuction> saveAuctionList = new ArrayList<>();
        List<SaveAuctionViewModel> saveAuctionViewModels = new ArrayList<>();
        List<Integer> historyAuctionsList = service.queryHistoryAuctionByUserId(userId);
        for (Integer licenseCarId : historyAuctionsList) {
            saveAuctionList = service.querySaveAuctionByLicenseCarId(licenseCarId);
            for (SaveAuction save : saveAuctionList) {
                SaveAuctionViewModel saveAuctionViewModel = new SaveAuctionViewModel();
                LocalDateTime date = save.getEndAuctionDate();
                ZoneId zoneId = ZoneId.systemDefault();
                long epoch = date.atZone(zoneId).toEpochSecond() * 1000;
                saveAuctionViewModel.setEndAuctionDate(epoch);
                saveAuctionViewModel.setFinalprice(save.getFinalprice());
                UserVM userVM = new UserVM();
                User user = save.getUser();
                userVM.setId(user.getId());
                userVM.setFirstname(user.getFirstname());
                userVM.setLastname(user.getLastname());
                LicenseCarVM licenseCarVM = new LicenseCarVM();
                LicenseCars licenseCars = save.getLicenseCars();
                licenseCarVM.setSeq(licenseCars.getSeq());
                licenseCarVM.setImageLicenseCar(licenseCars.getImageLicenseCar());
                licenseCarVM.setNumber(licenseCars.getNumber());
                saveAuctionViewModel.setUserVM(userVM);
                saveAuctionViewModel.setLicenseCarsVM(licenseCarVM);
                saveAuctionViewModels.add(saveAuctionViewModel);

            }
        }
            if (saveAuctionViewModels.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok().body(saveAuctionViewModels);
            }
    }

//    @PostMapping("querySaveAuctionByLicenseCarId")
//    public ResponseEntity querySaveAuction(@RequestParam(value = "licenseCarId") long licenseCarId){
//        List<SaveAuction> saveAuctionList = service.querySaveAuctionByLicenseCarId(licenseCarId);
//        List<SaveAuctionViewModel> saveAuctionViewModels = new ArrayList<>();
//        for(SaveAuction save : saveAuctionList){
//            SaveAuctionViewModel saveAuctionViewModel = new SaveAuctionViewModel();
//            LocalDateTime date = save.getEndAuctionDate();
//            ZoneId zoneId = ZoneId.systemDefault();
//            long epoch = date.atZone(zoneId).toEpochSecond()*1000;
//            saveAuctionViewModel.setEndAuctionDate(epoch);
//            saveAuctionViewModel.setFinalprice(save.getFinalprice());
//            UserVM userVM = new UserVM();
//            User user = save.getUser();
//            userVM.setId(user.getId());
//            userVM.setFirstname(user.getFirstname());
//            userVM.setLastname(user.getLastname());
//            LicenseCarVM licenseCarVM = new LicenseCarVM();
//            LicenseCars licenseCars = save.getLicenseCars();
//            licenseCarVM.setSeq(licenseCars.getSeq());
//            licenseCarVM.setImageLicenseCar(licenseCars.getImageLicenseCar());
//            licenseCarVM.setNumber(licenseCars.getNumber());
//            saveAuctionViewModel.setUserVM(userVM);
//            saveAuctionViewModel.setLicenseCarsVM(licenseCarVM);
//            saveAuctionViewModels.add(saveAuctionViewModel);
//
//        }
//        if(saveAuctionViewModels.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        }else{
//            return ResponseEntity.ok().body(saveAuctionViewModels);
//        }
//    }

    @GetMapping("queryHistoryAuctionByLicenseCarId")
    public ResponseEntity historyAuctionByLicenseCarId(@RequestParam(value = "licenseCarId") long licenseCarId){
        List<HistoryAuction> historyAuctionsList = service.queryHistoryAuctionByLicenseCarId(licenseCarId);
        List<HistoryAuctionViewModel> historyAuctionViewModelsList = new ArrayList<>();
        for(HistoryAuction historyAuction : historyAuctionsList){
            HistoryAuctionViewModel historyAuctionViewModel = new HistoryAuctionViewModel();
            LocalDateTime date = historyAuction.getAuctionTime();
            ZoneId zoneId = ZoneId.systemDefault();
            long epochAuctionTime = date.atZone(zoneId).toEpochSecond()*1000;
            historyAuctionViewModel.setAuctionTime(epochAuctionTime);
            historyAuctionViewModel.setAuctionPrice(historyAuction.getAuctionPrice());
            historyAuctionViewModel.setLicenseCarId(historyAuction.getLicenseCarId());
            UserVM userVM = new UserVM();
            userVM.setId(historyAuction.getUser().getId());
            userVM.setFirstname(historyAuction.getUser().getFirstname());
            userVM.setLastname(historyAuction.getUser().getLastname());
            historyAuctionViewModel.setUserVM(userVM);
            historyAuctionViewModelsList.add(historyAuctionViewModel);
        }
        if(historyAuctionViewModelsList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(historyAuctionViewModelsList);
        }
    }

    @GetMapping("checkStatusLicenseCarByLicenseCarId")
    public ResponseEntity checkStatusLicenseCarByLicenseCarId(@RequestParam(value = "licenseCarId") long licenseCarId){
        Long statusLicenseCar = service.checkStatusLicenseCarByLicenseCarId(licenseCarId);
        return ResponseEntity.ok().body(statusLicenseCar);
    }

    @GetMapping("countRegisterAuction")
    public ResponseEntity countRegisterAuction(@RequestParam(value = "licenseCarId")long licenseCarId){
        Long amountRegisterAuction = service.queryCountRegisterAuction(licenseCarId);
        return ResponseEntity.ok().body(amountRegisterAuction);
    }

}
