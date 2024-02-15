package com.isteer.dcm.compositekeys;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class OrdersCompositeKey implements Serializable {
    private BigDecimal order_id;

    public OrdersCompositeKey() {
    }

    public BigDecimal getOrder_id() {
        return order_id;
    }

    public void setOrder_id(BigDecimal order_id) {
        this.order_id = order_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdersCompositeKey that = (OrdersCompositeKey) o;
        return Objects.equals(order_id, that.order_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id);
    }
}
