package com.isteer.dcm.entity;

import com.isteer.dcm.compositekeys.ProductsCompositeKeys;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Products")
public class Products {

@EmbeddedId
    ProductsCompositeKeys productsCompositeKeys;
    private String product_name;
    private String Product_Description;
    private LocalDate mfg_date;
    private LocalDate expiry_date;
    private BigDecimal region_id;
    private BigDecimal sales_count;
    private String product_category;
    private BigDecimal refil_frequency;
    private String competetor_products_availability;
    private String collectionstatus;
    private String stockstatus;
    private BigDecimal inventory_size;
    private BigDecimal sellerid;
    private BigDecimal auditor_id;
    private BigDecimal rating;
    private String user_reviews;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_Description() {
        return Product_Description;
    }

    public void setProduct_Description(String product_Description) {
        Product_Description = product_Description;
    }

    public LocalDate getMfg_date() {
        return mfg_date;
    }

    public void setMfg_date(LocalDate mfg_date) {
        this.mfg_date = mfg_date;
    }

    public LocalDate getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(LocalDate expiry_date) {
        this.expiry_date = expiry_date;
    }


    public BigDecimal getRegion_id() {
        return region_id;
    }

    public void setRegion_id(BigDecimal region_id) {
        this.region_id = region_id;
    }

    public BigDecimal getSales_count() {
        return sales_count;
    }

    public void setSales_count(BigDecimal sales_count) {
        this.sales_count = sales_count;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public BigDecimal getRefil_frequency() {
        return refil_frequency;
    }

    public void setRefil_frequency(BigDecimal refil_frequency) {
        this.refil_frequency = refil_frequency;
    }

    public String getCompetetor_products_availability() {
        return competetor_products_availability;
    }

    public void setCompetetor_products_availability(String competetor_products_availability) {
        this.competetor_products_availability = competetor_products_availability;
    }

    public String getCollectionstatus() {
        return collectionstatus;
    }

    public void setCollectionstatus(String collectionstatus) {
        this.collectionstatus = collectionstatus;
    }

    public String getStockstatus() {
        return stockstatus;
    }

    public void setStockstatus(String stockstatus) {
        this.stockstatus = stockstatus;
    }

    public BigDecimal getInventory_size() {
        return inventory_size;
    }

    public void setInventory_size(BigDecimal inventory_size) {
        this.inventory_size = inventory_size;
    }

    public BigDecimal getSellerid() {
        return sellerid;
    }

    public void setSellerid(BigDecimal sellerid) {
        this.sellerid = sellerid;
    }

    public BigDecimal getAuditor_id() {
        return auditor_id;
    }

    public void setAuditor_id(BigDecimal auditor_id) {
        this.auditor_id = auditor_id;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getUser_reviews() {
        return user_reviews;
    }

    public void setUser_reviews(String user_reviews) {
        this.user_reviews = user_reviews;
    }

    public Products() {
    }

    public ProductsCompositeKeys getProductsCompositeKeys() {
        return productsCompositeKeys;
    }

    public void setProductsCompositeKeys(ProductsCompositeKeys productsCompositeKeys) {
        this.productsCompositeKeys = productsCompositeKeys;
    }

    // Constructors, getters, and setters
}

