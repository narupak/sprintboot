package com.example.sprintboot.entity;

import com.example.sprintboot.web.UserVM;

import java.util.List;

public class AuctionRealtimeDatabase {
    AuctionType licenseCar;

    String licenseCarId = null;

    public AuctionRealtimeDatabase() {
    }

    public AuctionType getLicenseCar() {
        return licenseCar;
    }

    public void setLicenseCar(AuctionType licenseCar) {
        this.licenseCar = licenseCar;
    }

    public String getLicenseCarId() {
        return licenseCarId;
    }

    public void setLicenseCarId(String licenseCarId) {
        this.licenseCarId = licenseCarId;
    }
}
