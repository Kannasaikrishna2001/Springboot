package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrderResponse {

    @JsonProperty("orderStatusList")
    private List<OrderStatus> orderStatusList;

    public List<OrderStatus> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<OrderStatus> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderStatusList=" + orderStatusList +
                '}';
    }
}
