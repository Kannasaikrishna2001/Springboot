package com.isteer.dcm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DISTRIBUTORINVENTORY")
public class DistributorInventory  {

    @Id
    @Column(name="DISTRIBUTOR_ID")
    private Integer distributorId;

    @Column(name="UPC")
    private Long upc;

    @Column(name="INVENTORY_SIZE")
    private Integer inventorySize;

    @Column(name="upc_Name")
    private String upcName;

    @Column(name="STOCK_STATUS")
    private String stockStatus;

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    public Integer getInventorySize() {
        return inventorySize;
    }

    public void setInventorySize(Integer inventorySize) {
        this.inventorySize = inventorySize;
    }

    public String getUpcName() {
        return upcName;
    }

    public void setUpcName(String upcName) {
        this.upcName = upcName;
    }

    public String getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(String stockStatus) {
        this.stockStatus = stockStatus;
    }
}
