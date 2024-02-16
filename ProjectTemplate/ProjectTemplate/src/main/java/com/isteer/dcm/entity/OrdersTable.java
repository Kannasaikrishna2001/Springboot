package com.isteer.dcm.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


    @Entity
    @Table(name = "OrdersTable")
    public class OrdersTable {
@Id
        private BigDecimal order_id;
        private String orderplaced_by;
        private String product_id;
        private String order_status;
        private LocalDateTime updatetime;
        private BigDecimal manufacturer_id;

        public BigDecimal getOrder_id() {
            return order_id;
        }

        public void setOrder_id(BigDecimal order_id) {
            this.order_id = order_id;
        }

        public String getOrderplaced_by() {
            return orderplaced_by;
        }

        public void setOrderplaced_by(String orderplaced_by) {
            this.orderplaced_by = orderplaced_by;
        }

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public LocalDateTime getUpdatetime() {
            return updatetime;
        }

        public void setUpdatetime(LocalDateTime updatetime) {
            this.updatetime = updatetime;
        }

        public BigDecimal getManufacturer_id() {
            return manufacturer_id;
        }

        public void setManufacturer_id(BigDecimal manufacturer_id) {
            this.manufacturer_id = manufacturer_id;
        }

        public OrdersTable() {
        }
    }


