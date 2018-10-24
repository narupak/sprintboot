package com.example.sprintboot.entity;

import java.util.Date;
import java.util.Map;

public class Winner extends FwEntity{
    Long bidder;
    Long bidTime;
    Long price;
    Long licenseCarId;
    Map<String,Member> member;

    public Winner() {
    }


    public Long getBidder() {
        return bidder;
    }

    public void setBidder(Long bidder) {
        this.bidder = bidder;
    }

    public Long getBidTime() {
        return bidTime;
    }

    public void setBidTime(Long bidTime) {
        this.bidTime = bidTime;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getLicenseCarId() {
        return licenseCarId;
    }

    public void setLicenseCarId(Long licenseCarId) {
        this.licenseCarId = licenseCarId;
    }

    public Map<String, Member> getMember() {
        return member;
    }

    public void setMember(Map<String, Member> member) {
        this.member = member;
    }
}
