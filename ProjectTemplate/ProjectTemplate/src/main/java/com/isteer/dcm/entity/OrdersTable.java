package com.isteer.dcm.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


    @Entity
    @Table(name = "Orders_Table")
    public class OrdersTable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long order_Id;
        private String order_PlacedBy;
        private String product_Id;
        private String order_Status;
        private LocalDateTime update_Time;
        private String manufacturer_Id;

        public OrdersTable() {

        }

        public Long getOrder_Id() {
            return order_Id;
        }

        public void setOrder_Id(Long order_Id) {
            this.order_Id = order_Id;
        }

        public String getOrder_PlacedBy() {
            return order_PlacedBy;
        }

        public void setOrder_PlacedBy(String order_PlacedBy) {
            this.order_PlacedBy = order_PlacedBy;
        }

        public String getProduct_Id() {
            return product_Id;
        }

        public void setProduct_Id(String product_Id) {
            this.product_Id = product_Id;
        }

        public String getOrder_Status() {
            return order_Status;
        }

        public void setOrder_Status(String order_Status) {
            this.order_Status = order_Status;
        }

        public LocalDateTime getUpdate_Time() {
            return update_Time;
        }

        public void setUpdate_Time(LocalDateTime update_Time) {
            this.update_Time = update_Time;
        }

        public String getManufacturer_Id() {
            return manufacturer_Id;
        }

        public OrdersTable(Long order_Id, String order_PlacedBy, String product_Id, String order_Status, LocalDateTime update_Time, String manufacturer_Id) {
            this.order_Id = order_Id;
            this.order_PlacedBy = order_PlacedBy;
            this.product_Id = product_Id;
            this.order_Status = order_Status;
            this.update_Time = update_Time;
            this.manufacturer_Id = manufacturer_Id;
        }

        public void setManufacturer_Id(String manufacturer_Id) {
            this.manufacturer_Id = manufacturer_Id;

        }
    }
