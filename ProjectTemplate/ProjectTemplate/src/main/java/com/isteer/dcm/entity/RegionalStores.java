package com.isteer.dcm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "regionalStores")
public class RegionalStores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "regionId")
    private Long regionId;

    @Column(name = "regionName")
    private String regionName;

    @Column(name = "storeId")
    private int storeId;

    @Column(name = "storeName")
    private String storeName;

    @Column(name = "storeStatus")
    private String storeStatus;

    @Column(name = "upstreamFileLocation")
    private String upstreamFileLocation;

    @Column(name = "archiveLocation")
    private String archiveLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(String storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getUpstreamFileLocation() {
        return upstreamFileLocation;
    }

    public void setUpstreamFileLocation(String upstreamFileLocation) {
        this.upstreamFileLocation = upstreamFileLocation;
    }

    public String getArchiveLocation() {
        return archiveLocation;
    }

    public void setArchiveLocation(String archiveLocation) {
        this.archiveLocation = archiveLocation;
    }
}
