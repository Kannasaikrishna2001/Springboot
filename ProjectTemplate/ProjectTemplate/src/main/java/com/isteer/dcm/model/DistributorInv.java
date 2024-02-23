package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistributorInv {
    @JsonProperty("upc")
    private Long upc;

    @JsonProperty("inventory_size")
    private Integer inventory_size;

    @JsonProperty("upc_name")
    private String upc_name;

    @JsonProperty("stock_status")
    private String stock_status;

    public DistributorInv(String toString) {
    }

    /*public DistributorInv(Long upc, Integer inventory_size, String upc_name, String stock_status) {
        this.upc = upc;
        this.inventory_size = inventory_size;
        this.upc_name = upc_name;
        this.stock_status = stock_status;
    }*/

    public DistributorInv() {

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

    public String getUpc_name() {
        return upc_name;
    }

    public void setUpc_name(String upc_name) {
        this.upc_name = upc_name;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    @Override
    public String toString() {
        return "DistributorInv{" +
                "upc=" + upc +
                ", inventory_size=" + inventory_size +
                ", upc_name='" + upc_name + '\'' +
                ", stock_status='" + stock_status + '\'' +
                '}';
    }
}
