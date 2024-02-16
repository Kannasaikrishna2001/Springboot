package com.isteer.dcm.compositekeys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ProductCompositeKey implements Serializable {

    private BigDecimal upc;
    private BigDecimal store_id;

    public BigDecimal getUpc() {
        return upc;
    }

    public void setUpc(BigDecimal upc) {
        this.upc = upc;
    }

    public BigDecimal getStore_id() {
        return store_id;
    }

    public void setStore_id(BigDecimal store_id) {
        this.store_id = store_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCompositeKey that = (ProductCompositeKey) o;
        return Objects.equals(upc, that.upc) && Objects.equals(store_id, that.store_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upc, store_id);
    }

    public ProductCompositeKey() {
    }
}
