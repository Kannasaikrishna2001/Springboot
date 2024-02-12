package com.isteer.dcm.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "upc")
    private String upc;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "mfg_date")
    private Date manufacturingDate;

    @Column(name = "expiry_date")
    private Date expiryDate;




    @Column(name = "sales_count")
    private Integer salesCount;

    @Column(name = "product_category")
    private String productCategory;

    @Column(name = "refill_frequency")
    private Integer refillFrequency;

    @Column(name = "competitor_products_availability")
    private String competitorProductsAvailability;

    @Column(name = "collection_status")
    private String collectionStatus;

    @Column(name = "stock_status")
    private String stockStatus;


}
