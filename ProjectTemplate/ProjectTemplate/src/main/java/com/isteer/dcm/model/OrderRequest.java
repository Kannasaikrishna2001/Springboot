package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderRequest {
    @JsonProperty("PLACE ORDER")
    private List<OrderItem> placeOrder;
    private String distributorId;
    private String productId;
    public List<OrderItem> getPlaceOrder() {
        return placeOrder;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPlaceOrder(List<OrderItem> placeOrder) {
        this.placeOrder = placeOrder;
    }

    public String getDistributorId() {
        if (placeOrder != null && !placeOrder.isEmpty()) {
            return placeOrder.get(0).getDistributorId();
        } else {
            return distributorId; // or return a default value if distributor ID is not available
        }
    }

    public Object getProductId() {
        if (placeOrder != null && !placeOrder.isEmpty()) {
            return placeOrder.get(0).getUpc();
        } else {
            return productId; // or return a default value if distributor ID is not available
        }
    }
}
