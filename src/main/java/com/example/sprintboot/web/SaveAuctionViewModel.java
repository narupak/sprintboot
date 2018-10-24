package com.example.sprintboot.web;

import com.example.sprintboot.entity.LicenseCars;
import com.example.sprintboot.entity.User;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;

public class SaveAuctionViewModel {

    @SerializedName("seq")
    private Long seq;

    @SerializedName("endAuctionDate")
    private long endAuctionDate;

    @SerializedName("finalprice")
    private Long finalprice;

    @SerializedName("licenseCarsVM")
    private LicenseCarVM licenseCarsVM;

    @SerializedName("userVM")
    private UserVM userVM;

    public SaveAuctionViewModel() {
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public long getEndAuctionDate() {
        return endAuctionDate;
    }

    public void setEndAuctionDate(long endAuctionDate) {
        this.endAuctionDate = endAuctionDate;
    }

    public Long getFinalprice() {
        return finalprice;
    }

    public void setFinalprice(Long finalprice) {
        this.finalprice = finalprice;
    }

    public LicenseCarVM getLicenseCarsVM() {
        return licenseCarsVM;
    }

    public void setLicenseCarsVM(LicenseCarVM licenseCarsVM) {
        this.licenseCarsVM = licenseCarsVM;
    }

    public UserVM getUserVM() {
        return userVM;
    }

    public void setUserVM(UserVM userVM) {
        this.userVM = userVM;
    }
}
