package com.isteer.dcm.model;

import java.time.LocalDate;

import java.time.LocalDate;

public class Production {
    private String upc;
    private String productName;
    private String productDescription;
    private LocalDate manufacturingDate;
    private LocalDate expiryDate;
    private int storeId;
    private String storeName;
    private String storeAddress;
    private String regionId;
    private String regionName;
    private int salesCount;
    private String productCategory;
    private int stockInStore;
    private String refillFrequency;
    private boolean competitorProductsAvailable;
    private String collectionStatus;
    private String stockStatus;
    private int sellerId;
    // Constructors, getters, and setters

    public Production() {
    }

    public Production(String upc, String productName, String productDescription, LocalDate manufacturingDate, LocalDate expiryDate, int storeId, String storeName, String storeAddress, String regionId, String regionName, int salesCount, String productCategory, int stockInStore, String refillFrequency, boolean competitorProductsAvailable, String collectionStatus, String stockStatus) {
        this.upc = upc;
        this.productName = productName;
        this.productDescription = productDescription;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.storeId = storeId;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.regionId = regionId;
        this.regionName = regionName;
        this.salesCount = salesCount;
        this.productCategory = productCategory;
        this.stockInStore = stockInStore;
        this.refillFrequency = refillFrequency;
        this.competitorProductsAvailable = competitorProductsAvailable;
        this.collectionStatus = collectionStatus;
        this.stockStatus = stockStatus;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
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

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getStockInStore() {
        return stockInStore;
    }

    public void setStockInStore(int stockInStore) {
        this.stockInStore = stockInStore;
    }

    public String getRefillFrequency() {
        return refillFrequency;
    }

    public void setRefillFrequency(String refillFrequency) {
        this.refillFrequency = refillFrequency;
    }

    public boolean isCompetitorProductsAvailable() {
        return competitorProductsAvailable;
    }

    public void setCompetitorProductsAvailable(boolean competitorProductsAvailable) {
        this.competitorProductsAvailable = competitorProductsAvailable;
    }

    public String getCollectionStatus() {
        return collectionStatus;
    }

    public void setCollectionStatus(String collectionStatus) {
        this.collectionStatus = collectionStatus;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }

    @Override
    public String toString() {
        return "Production{" +
                "upc='" + upc + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", manufacturingDate=" + manufacturingDate +
                ", expiryDate=" + expiryDate +
                ", storeId=" + storeId +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", regionId='" + regionId + '\'' +
                ", regionName='" + regionName + '\'' +
                ", salesCount=" + salesCount +
                ", productCategory='" + productCategory + '\'' +
                ", stockInStore=" + stockInStore +
                ", refillFrequency='" + refillFrequency + '\'' +
                ", competitorProductsAvailable=" + competitorProductsAvailable +
                ", collectionStatus='" + collectionStatus + '\'' +
                ", stockStatus='" + stockStatus + '\'' +
                '}';
    }
}

