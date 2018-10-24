package com.example.sprintboot.web;

import com.example.sprintboot.entity.LicenseCars;

import java.time.LocalDateTime;
import java.util.List;

public class UserVM {

    private long id;
    private Long version;
    private String createBy;
    private LocalDateTime createDate;
    private String firstname;
    private String lastname;
    private String mail;
    private String password;
    private String tel;
    private String updateBy;
    private LocalDateTime updateDate;
    private String username;
    private String address;
    private List<LicenseCars> licenseCarsList;

    public UserVM(long id, Long version, String createBy, LocalDateTime createDate, String firstname, String lastname, String mail, String password, String tel, String updateBy, LocalDateTime updateDate, String username, String address, List<LicenseCars> licenseCarsList) {
        this.id = id;
        this.version = version;
        this.createBy = createBy;
        this.createDate = createDate;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mail = mail;
        this.password = password;
        this.tel = tel;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.username = username;
        this.address = address;
        this.licenseCarsList = licenseCarsList;
    }

    public UserVM() {
    }

    @Override
    public String toString() {
        return "UserVM{" +
                "id=" + id +
                ", version=" + version +
                ", createBy='" + createBy + '\'' +
                ", createDate=" + createDate +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", updateBy='" + updateBy + '\'' +
                ", updateDate=" + updateDate +
                ", username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", licenseCarsList=" + licenseCarsList +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<LicenseCars> getLicenseCarsList() {
        return licenseCarsList;
    }

    public void setLicenseCarsList(List<LicenseCars> licenseCarsList) {
        this.licenseCarsList = licenseCarsList;
    }
}
