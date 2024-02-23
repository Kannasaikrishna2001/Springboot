package com.isteer.dcm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isteer.dcm.entity.DistributorInventory;

import java.util.List;
import java.util.Optional;

public class Response {
    @JsonProperty("ResponseCode")
    private String responseCode;
    @JsonProperty("ResponseMessage")
    private String responseMessage;

    @JsonProperty("DistributorInventory")
    private List<DistributorInv> distributorInvs;

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

    public List<DistributorInv> getDistributorInvs() {
        return distributorInvs;
    }

    public void setDistributorInvs(List<DistributorInv> distributorInvs) {
        this.distributorInvs = distributorInvs;
    }
}
