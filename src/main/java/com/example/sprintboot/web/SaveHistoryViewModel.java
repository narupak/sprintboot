package com.example.sprintboot.web;

public class SaveHistoryViewModel {

    Long id;
    Long price;
    Long date;
    Long licenseCarId;

    public SaveHistoryViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getLicenseCarId() {
        return licenseCarId;
    }

    public void setLicenseCarId(Long licenseCarId) {
        this.licenseCarId = licenseCarId;
    }
}
