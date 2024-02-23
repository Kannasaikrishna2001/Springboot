package com.isteer.dcm.controller;

import com.isteer.dcm.service.DistributorInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.isteer.dcm.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dcm")
public class DistributorInvController {
    @Autowired
    DistributorInventoryService distributorInventoryService;

    @GetMapping("/distributor/{distributorId}")
    public ResponseEntity<Response> getDistributorById(@PathVariable Long distributorId) {
        Response response = distributorInventoryService.getDistributorById(distributorId);
        return ResponseEntity.ok(response);
    }

}
