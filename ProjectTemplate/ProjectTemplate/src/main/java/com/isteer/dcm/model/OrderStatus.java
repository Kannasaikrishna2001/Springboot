package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatus {
    @JsonProperty("UPC")
    private String upc;

    @JsonProperty("OrderStatus")
    private String orderStatus;

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "upc='" + upc + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
