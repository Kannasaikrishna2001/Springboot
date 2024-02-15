package com.isteer.dcm.model;

import java.util.List;

public class OrderRequest {
    private List<OrderItem> placeOrder;

    public List<OrderItem> getPlaceOrder() {
        return placeOrder;
    }

    public void setPlaceOrder(List<OrderItem> placeOrder) {
        this.placeOrder = placeOrder;
    }
}
