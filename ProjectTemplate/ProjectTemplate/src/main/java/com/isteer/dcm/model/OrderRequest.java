package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequest {
    @JsonProperty("PLACE ORDER")
    private List<OrderItem> placeOrder;

    public List<OrderItem> getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(List<OrderItem> placeOrder) {
        this.placeOrder = placeOrder;
    }

    public String getDistributorId() {
        return null;
    }

    public Object getProductId() {
        return null;
    }
}
