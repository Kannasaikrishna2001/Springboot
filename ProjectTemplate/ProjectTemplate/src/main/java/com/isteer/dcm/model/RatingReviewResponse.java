package com.isteer.dcm.model;

import java.math.BigDecimal;

public class RatingReviewResponse {
    private String upc;
    private String productName;
    private BigDecimal rating;
    private String review;

    public RatingReviewResponse(String upc, String productName, BigDecimal rating, String review) {
        this.upc = upc;
        this.productName = productName;
        this.rating = rating;
        this.review = review;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "RatingReviewResponse{" +
                "upc='" + upc + '\'' +
                ", productName='" + productName + '\'' +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
