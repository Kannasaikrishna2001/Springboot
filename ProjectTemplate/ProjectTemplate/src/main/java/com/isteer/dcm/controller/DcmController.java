package com.isteer.dcm.controller;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.Products;
import com.isteer.dcm.model.OrderRequest;
import com.isteer.dcm.model.OrderResponse;
import com.isteer.dcm.service.LogServiceImpl;
import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.service.ReviewAndRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/orders")
public class DcmController {

    private static final Logger logger = LoggerFactory.getLogger(DcmController.class);
    @Autowired
    LogServiceImpl logService;


    @PostMapping("/log-error")
    public String logError(
            @RequestParam String processName,
            @RequestParam String errorMessage,
            @RequestParam(required = false) String stackTrace,
            @RequestParam(required = false) String processId,
            @RequestParam(required = false) String request,
            @RequestParam(required = false) String response) {

        logService.logData(processName, errorMessage, stackTrace, processId, request, response);

        return "Logged error successfully";
    }
    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        try {
            OrderResponse response = orderService.placeOrder(request);
            logger.info("Order placed successfully for distributor: {}, product: {}", request.getDistributorId(), request.getProductId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error occurred while placing order", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Autowired
    private ReviewAndRating reviewAndRating;

    @GetMapping("/{store_id}/ratings-reviews")
    public ResponseEntity<Map<String, Object>> getRatingsAndReviews(@PathVariable String store_id) {
        Products product = reviewAndRating.getProductByStoreId(store_id);
        if (product != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("upc", product.getProductsCompositeKeys().getUpc());
            response.put("product_name", product.getProduct_name());
            response.put("rating", product.getRating());
            response.put("review", product.getUser_reviews());

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}