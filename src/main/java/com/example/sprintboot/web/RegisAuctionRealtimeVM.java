package com.example.sprintboot.web;


import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RegisAuctionRealtimeVM extends LinkedHashMap<String, RegisAuctionRealtimeVM> {

        HashMap<String,RegisterAuctionVM> registerAuctionVMHashMap;

    @SerializedName("userId")
    private long userId;
    @SerializedName("licenseCarId")
    private long licenseCarId;

    private LocalDate registerDate;

    @SerializedName("seq")
    private long seq;

    @SerializedName("licenseCarVM")
    private LicenseCarVM licenseCarVM;

    @SerializedName("userVM")
    private UserVM userVM;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLicenseCarId() {
        return licenseCarId;
    }

    public void setLicenseCarId(long licenseCarId) {
        this.licenseCarId = licenseCarId;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public LicenseCarVM getLicenseCarVM() {
        return licenseCarVM;
    }

    public void setLicenseCarVM(LicenseCarVM licenseCarVM) {
        this.licenseCarVM = licenseCarVM;
    }

    public UserVM getUserVM() {
        return userVM;
    }

    public void setUserVM(UserVM userVM) {
        this.userVM = userVM;
    }

    public RegisAuctionRealtimeVM(HashMap<String, RegisterAuctionVM> registerAuctionVMHashMap) {
            this.registerAuctionVMHashMap = registerAuctionVMHashMap;
        }

        public HashMap<String, RegisterAuctionVM> getRegisterAuctionVMHashMap() {
            return registerAuctionVMHashMap;
        }

        public void setRegisterAuctionVMHashMap(HashMap<String, RegisterAuctionVM> registerAuctionVMHashMap) {
            this.registerAuctionVMHashMap = registerAuctionVMHashMap;
        }
}
