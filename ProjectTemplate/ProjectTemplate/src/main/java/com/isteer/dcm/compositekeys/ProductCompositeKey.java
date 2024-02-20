package com.isteer.dcm.compositekeys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ProductCompositeKey implements Serializable {

    private BigDecimal upc;
    private BigDecimal store_Id;

    public BigDecimal getUpc() {
        return upc;
    }

    public void setUpc(BigDecimal upc) {
        this.upc = upc;
    }

    public BigDecimal getStore_Id() {
        return store_Id;
    }

    public void setStore_Id(BigDecimal store_Id) {
        this.store_Id = store_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCompositeKey that = (ProductCompositeKey) o;
        return Objects.equals(upc, that.upc) && Objects.equals(store_Id, that.store_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upc, store_Id);
    }

    public ProductCompositeKey() {
    }
}
