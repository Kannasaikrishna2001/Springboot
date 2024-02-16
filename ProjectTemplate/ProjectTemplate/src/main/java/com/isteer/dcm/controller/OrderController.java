/*
package com.isteer.dcm.controller;

import com.isteer.dcm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestParam String distributorId, @RequestParam String productId, @RequestParam String upc) {
        boolean success = orderService.placeOrder(distributorId, productId, upc);
        if (success) {
            return ResponseEntity.ok("Order placed successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to place order");
        }
    }
}
*/
