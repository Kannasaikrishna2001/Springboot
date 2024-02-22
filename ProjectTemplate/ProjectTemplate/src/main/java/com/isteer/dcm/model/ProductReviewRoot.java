package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductReviewRoot {
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseMessage")
    private String responseMessage;
    @JsonProperty("Ratings and Reviews ")
    private List<RatingReviewResponse> ratingReviewResponses;

    public List<RatingReviewResponse> getRatingReviewResponses() {
        return ratingReviewResponses;
    }

    public void setRatingReviewResponses(List<RatingReviewResponse> ratingReviewResponses) {
        this.ratingReviewResponses = ratingReviewResponses;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

  /*  public List<RatingReviewResponse> getRatingReviewResponses() {
        return ratingReviewResponses;
    }

    public void setRatingReviewResponses(List<RatingReviewResponse> ratingReviewResponses) {
        this.ratingReviewResponses = ratingReviewResponses;
    }*/
}