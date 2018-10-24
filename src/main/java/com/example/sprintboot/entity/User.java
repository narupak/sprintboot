package com.example.sprintboot.entity;
// Generated Oct 8, 2018 8:48:14 AM by Hibernate Tools 5.2.5.Final


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="auction"
    , uniqueConstraints = {@UniqueConstraint(columnNames="password"), @UniqueConstraint(columnNames="username")} 
)
public class User  extends FwEntity implements java.io.Serializable {


     private Long id;
     private Long version;
     private String createBy;
     private LocalDateTime createDate;
     private String updateBy;
     private LocalDateTime updateDate;
     private String address;
     private String firstname;
     private String lastname;
     private String mail;
     private String password;
     private String tel;
     private String username;

    public User() {
    }

    public User(String createBy, LocalDateTime createDate, String updateBy, LocalDateTime updateDate, String address, String firstname, String lastname, String mail, String password, String tel, String username) {
       this.createBy = createBy;
       this.createDate = createDate;
       this.updateBy = updateBy;
       this.updateDate = updateDate;
       this.address = address;
       this.firstname = firstname;
       this.lastname = lastname;
       this.mail = mail;
       this.password = password;
       this.tel = tel;
       this.username = username;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name="version")
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }

    
    @Column(name="create_by", length=13)
    public String getCreateBy() {
        return this.createBy;
    }
    
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    
    @Column(name="create_date", length=26)
    public LocalDateTime getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="update_by", length=13)
    public String getUpdateBy() {
        return this.updateBy;
    }
    
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    
    @Column(name="update_date", length=26)
    public LocalDateTime getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    
    @Column(name="address", length=45)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    
    @Column(name="firstname", length=45)
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    
    @Column(name="lastname", length=45)
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    
    @Column(name="mail", length=45)
    public String getMail() {
        return this.mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }

    
    @Column(name="password", unique=true, length=45)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="tel", length=45)
    public String getTel() {
        return this.tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }

    
    @Column(name="username", unique=true, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }




}

