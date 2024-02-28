package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequest {
    @JsonProperty("DISTRIBUTOR ID")
    private String distributorId;

    @JsonProperty("PLACE ORDER")
    private List<OrderItem> placeOrder;

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public List<OrderItem> getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(List<OrderItem> placeOrder) {
        this.placeOrder = placeOrder;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "distributorId='" + distributorId + '\'' +
                ", placeOrder=" + placeOrder +
                '}';
    }
}
