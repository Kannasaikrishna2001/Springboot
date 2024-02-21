package com.isteer.dcm.controller;

import com.isteer.dcm.entity.Products;
import com.isteer.dcm.model.OrderRequest;
import com.isteer.dcm.model.OrderResponse;
import com.isteer.dcm.model.RatingReviewResponse;
//import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.service.ReviewAndRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/dcm")
public class DcmController {

    private static final Logger logger = LoggerFactory.getLogger(DcmController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReviewAndRating reviewAndRating;
    /*
     * revisit the order response as it will not work in case if order is placed for multiple upcs
     * each upc should have its status seperately , whether the order is placed for that very upc or not
     * consider restructuring the response model by keeping upc and order status as two elements inside a chile model which it iterative and have one root model class as the response
     * the code will not work in all of the below scenarios
     * 1: when one of the upcs is present and one or more is not
     * 3: check for all other possible scenarios as well apart from the two mentioned above
     * */

    @PostMapping("/place-order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        try {
            // Log distributorId and productId if they are not null
            String distributorId = request.getDistributorId() != null ? request.getDistributorId() : "Unknown";
            String productId = request.getProductId() != null ? request.getProductId().toString() : "Unknown";

            // Log the request details
            logger.info("Order placed successfully for distributor: {}, product: {}", distributorId, productId);

            // Place the order
            OrderResponse response = orderService.placeOrder(request);

            // Return the response
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error occurred while placing order", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping(value = "/ratings-reviews")
    public ResponseEntity<RatingReviewResponse> getRatingsAndReviews(@RequestParam int sellerid) {

        Products product = reviewAndRating.sellerValidation(sellerid);
       // Products product = reviewAndRating.getProductBySellerId(BigDecimal.valueOf(sellerid));

            if (product != null) {
                RatingReviewResponse response = new RatingReviewResponse(

                        product.getProductsCompositeKeys().getUpc().toString(),
                        product.getProduct_name(),
                        product.getRating(),
                        product.getUser_reviews()
                );

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.notFound().build();
            }

    }
}