package com.isteer.dcm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REGIONALSTORE")
public class RegionalStores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    @Column(name = "STORE_ID")
    private int storeId;

    @Column(name = "STORE_NAME")
    private String storeName;

    @Column(name = "STORE_STATUS")
    private String storeStatus;

    @Column(name = "UPSTREAM_FILELOCATION")
    private String upstreamFileLocation;

    @Column(name = "ARCHIVE_LOCATION")
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
