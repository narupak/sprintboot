package com.example.sprintboot.entity;
// Generated Oct 8, 2018 3:37:49 PM by Hibernate Tools 5.2.5.Final


import java.time.LocalDateTime;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * HistoryAuction generated by hbm2java
 */
@Entity
@Table(name="history_auction"
    ,catalog="auction"
)
public class HistoryAuction  implements java.io.Serializable {


     private Long seq;
    private Long version;
    private User user;
    private LocalDateTime auctionTime;
    private Long auctionPrice;
    private String createBy;
    private LocalDateTime createDate;
    private String updateBy;
    private LocalDateTime updateDate;
    private Long licenseCarId;

    public HistoryAuction() {
    }


    public HistoryAuction(Long seq, Long version, User user, LocalDateTime auctionTime, Long auctionPrice, String createBy, LocalDateTime createDate, String updateBy, LocalDateTime updateDate, Long licenseCarId) {
        this.seq = seq;
        this.version = version;
        this.user = user;
        this.auctionTime = auctionTime;
        this.auctionPrice = auctionPrice;
        this.createBy = createBy;
        this.createDate = createDate;
        this.updateBy = updateBy;
        this.updateDate = updateDate;
        this.licenseCarId = licenseCarId;
    }

    @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="seq", unique=true, nullable=false)
    public Long getSeq() {
        return this.seq;
    }
    
    public void setSeq(Long seq) {
        this.seq = seq;
    }

    @Version
    @Column(name="version")
    public Long getVersion() {
        return this.version;
    }
    
    public void setVersion(Long version) {
        this.version = version;
    }



    @OneToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    
    @Column(name="auction_time", length=26)
    public LocalDateTime getAuctionTime() {
        return this.auctionTime;
    }
    
    public void setAuctionTime(LocalDateTime auctionTime) {
        this.auctionTime = auctionTime;
    }

    
    @Column(name="auction_price", nullable=false)
    public Long getAuctionPrice() {
        return this.auctionPrice;
    }
    
    public void setAuctionPrice(Long auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    
    @Column(name="create_by", length=45)
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

    
    @Column(name="update_by", length=45)
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

    
    @Column(name="license_car_id", nullable=false)
    public Long getLicenseCarId() {
        return this.licenseCarId;
    }
    
    public void setLicenseCarId(Long licenseCarId) {
        this.licenseCarId = licenseCarId;
    }




}


