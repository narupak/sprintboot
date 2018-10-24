package com.example.sprintboot.web;

import com.example.sprintboot.entity.LicenseCars;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class RegisterAuctionVM {

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

    public RegisterAuctionVM(int userId, int licenseCarId, LocalDate registerDate, int seq, LicenseCarVM licenseCarVM, UserVM userVM) {
        this.userId = userId;
        this.licenseCarId = licenseCarId;
        this.registerDate = registerDate;
        this.seq = seq;
        this.licenseCarVM = licenseCarVM;
        this.userVM = userVM;
    }

    public RegisterAuctionVM(long userId, int licenseCarId, LocalDate registerDate) {
        this.userId = userId;
        this.licenseCarId = licenseCarId;
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

    public RegisterAuctionVM() {
    }

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

    @Override
    public String toString() {
        return "RegisterAuctionVM{" +
                "userId=" + userId +
                ", licenseCarId=" + licenseCarId +
                ", registerDate=" + registerDate +
                '}';
    }
}
