package com.isteer.dcm.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class DistributorCompositeKey implements Serializable {
    @Column(name="DISTRIBUTOR_ID")
    private Integer distributorId;

    @Column(name="UPC")
    private Long upc;

    public Integer getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Integer distributorId) {
        this.distributorId = distributorId;
    }

    public Long getUpc() {
        return upc;
    }

    public void setUpc(Long upc) {
        this.upc = upc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistributorCompositeKey that = (DistributorCompositeKey) o;
        return distributorId.equals(that.distributorId) && upc.equals(that.upc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(distributorId, upc);
    }
}
