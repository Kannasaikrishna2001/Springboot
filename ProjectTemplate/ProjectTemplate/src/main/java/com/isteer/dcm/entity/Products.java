package com.isteer.dcm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Products {

    @Id
    private String upc;
    private String product_Name;
    private String productDescription;
    private LocalDate mfgDate;
    private LocalDate expiryDate;
    private String storeId;
    private String regionId;
    private int salesCount;
    private String productCategory;
    private String refilFrequency;
    private String competetorProductsAvailability;
    private String collectionStatus;
    private String stockStatus;
    private int inventorySize;
    private String sellerId;

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductName() {
        return product_Name;
    }

    public void setProductName(String productName) {
        this.product_Name = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public LocalDate getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(LocalDate mfgDate) {
        this.mfgDate = mfgDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
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

    public String getRefilFrequency() {
        return refilFrequency;
    }

    public void setRefilFrequency(String refilFrequency) {
        this.refilFrequency = refilFrequency;
    }

    public String getCompetetorProductsAvailability() {
        return competetorProductsAvailability;
    }

    public void setCompetetorProductsAvailability(String competetorProductsAvailability) {
        this.competetorProductsAvailability = competetorProductsAvailability;
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

    public int getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    // Constructors, getters, and setters
}

