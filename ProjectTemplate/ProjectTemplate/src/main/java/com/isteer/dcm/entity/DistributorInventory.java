package com.isteer.dcm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DistributorInventory")
public class DistributorInventory {

    @Id

    @Column(name="distributor_Id")
    private Integer distributor_Id;

    @Column(name="upc")
    private Long upc;

    @Column(name="inventory_size")
    private Integer inventory_size;

    @Column(name="upc_Name")
    private String upc_Name;

    @Column(name="stock_status")
    private String stock_status;

    public Integer getDistributor_Id() {
        return distributor_Id;
    }

    public void setDistributor_Id(Integer distributor_Id) {
        this.distributor_Id = distributor_Id;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    public Integer getInventory_size() {
        return inventory_size;
    }

    public void setInventory_size(Integer inventory_size) {
        this.inventory_size = inventory_size;
    }

    public String getUpc_Name() {
        return upc_Name;
    }

    public void setUpc_Name(String upc_Name) {
        this.upc_Name = upc_Name;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }
}
