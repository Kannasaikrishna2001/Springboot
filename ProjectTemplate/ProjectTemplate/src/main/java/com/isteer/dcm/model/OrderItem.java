package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isteer.dcm.compositekeys.ProductCompositeKey;

import java.math.BigDecimal;

public class OrderItem {

    @JsonProperty("UPC")
    private BigDecimal upc;
    @JsonProperty("OrderSize")
    private BigDecimal orderSize;


    public BigDecimal getUpc() {
        return upc;
    }

    public void setUpc(BigDecimal upc) {
        this.upc = upc;
    }

    public BigDecimal getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(BigDecimal orderSize) {
        this.orderSize = orderSize;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "upc=" + upc +
                ", orderSize=" + orderSize +
                '}';
    }
}
