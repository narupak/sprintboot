package com.example.sprintboot.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LicenseCarVM {
    private Long seq;
    private Long version;
    private long acutionDate;
    private long auctionTime;
    private long endRegisterDate;
    private Long firstprice;
    private String imageLicenseCar;
    private String number;
    private long startRegisterDate;
    private String status;

    public LicenseCarVM(Long seq, Long version, long acutionDate, long auctionTime, long endRegisterDate, Long firstprice, String imageLicenseCar, String number, long startRegisterDate, String status) {
        this.seq = seq;
        this.version = version;
        this.acutionDate = acutionDate;
        this.auctionTime = auctionTime;
        this.endRegisterDate = endRegisterDate;
        this.firstprice = firstprice;
        this.imageLicenseCar = imageLicenseCar;
        this.number = number;
        this.startRegisterDate = startRegisterDate;
        this.status = status;
    }

    public LicenseCarVM() {
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

    public long getAcutionDate() {
        return acutionDate;
    }

    public void setAcutionDate(long acutionDate) {
        this.acutionDate = acutionDate;
    }

    public long getAuctionTime() {
        return auctionTime;
    }

    public void setAuctionTime(long auctionTime) {
        this.auctionTime = auctionTime;
    }

    public long getEndRegisterDate() {
        return endRegisterDate;
    }

    public void setEndRegisterDate(long endRegisterDate) {
        this.endRegisterDate = endRegisterDate;
    }

    public Long getFirstprice() {
        return firstprice;
    }

    public void setFirstprice(Long firstprice) {
        this.firstprice = firstprice;
    }

    public String getImageLicenseCar() {
        return imageLicenseCar;
    }

    public void setImageLicenseCar(String imageLicenseCar) {
        this.imageLicenseCar = imageLicenseCar;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getStartRegisterDate() {
        return startRegisterDate;
    }

    public void setStartRegisterDate(long startRegisterDate) {
        this.startRegisterDate = startRegisterDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
