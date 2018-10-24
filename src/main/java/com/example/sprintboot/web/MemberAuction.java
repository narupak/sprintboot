package com.example.sprintboot.web;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class MemberAuction {
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
    private List<UserVM> userVM;

    public MemberAuction() {
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

    public List<UserVM> getUserVM() {
        return userVM;
    }

    public void setUserVM(List<UserVM> userVM) {
        this.userVM = userVM;
    }
}
