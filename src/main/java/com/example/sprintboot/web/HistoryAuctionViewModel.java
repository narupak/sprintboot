package com.example.sprintboot.web;

import java.time.LocalDateTime;

public class HistoryAuctionViewModel {
    private Long seq;
    private Long version;
    private UserVM userVM;
    private Long auctionTime;
    private Long auctionPrice;
    private String createBy;
    private Long createDate;
    private String updateBy;
    private Long updateDate;
    private Long licenseCarId;

    public HistoryAuctionViewModel() {
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public UserVM getUserVM() {
        return userVM;
    }

    public void setUserVM(UserVM userVM) {
        this.userVM = userVM;
    }

    public Long getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(Long auctionTime) {
        this.auctionTime = auctionTime;
    }

    public Long getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Long auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Long getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Long updateDate) {
        this.updateDate = updateDate;
    }

    public Long getLicenseCarId() {
        return licenseCarId;
    }

    public void setLicenseCarId(Long licenseCarId) {
        this.licenseCarId = licenseCarId;
    }
}
