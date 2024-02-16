package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isteer.dcm.compositekeys.ProductCompositeKey;

import java.math.BigDecimal;

public class OrderItem {

    @JsonProperty("DistributorId")
    private String distributorId;
    @JsonProperty("UPC")
    private ProductCompositeKey upc;
    @JsonProperty("OrderSize")
    private BigDecimal orderSize;

    public String getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(String distributorId) {
        this.distributorId = distributorId;
    }

    public ProductCompositeKey getUpc() {
        return upc;
    }

    public void setUpc(ProductCompositeKey upc) {
        this.upc = upc;
    }

    public BigDecimal getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(BigDecimal orderSize) {
        this.orderSize = orderSize;
    }
}
