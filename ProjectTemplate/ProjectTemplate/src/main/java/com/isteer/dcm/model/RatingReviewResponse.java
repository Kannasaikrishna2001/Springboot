package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class RatingReviewResponse {
    @JsonProperty("UPC")
    private String upc;

    @JsonProperty("PRODUCT NAME")
    private String productName;

    @JsonProperty("RATING")
    private String rating;

    @JsonProperty("USER REVIEWS")
    private String review;

    public RatingReviewResponse() {
    }

    public RatingReviewResponse(String upc, String productName, String rating, String review) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
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
