package com.isteer.dcm.controller;

import com.isteer.dcm.entity.Products;
import com.isteer.dcm.model.OrderRequest;
import com.isteer.dcm.model.OrderResponse;
import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.service.ReviewAndRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


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
            OrderResponse response = orderService.placeOrder(request);
            logger.info("Order placed successfully for distributor: {}, product: {}", request.getDistributorId(), request.getProductId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error occurred while placing order", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //pass manufacturer id instead of store id as a resource parameter

    //create a response object with below set of fields
    /* create a model class with below set of repititive elements and have a single root element returned as repsone
    * upc, product name, product description rating and review
    *
    * validate the manufacturer before fetching the review of products use the on startup data load for that
    * handle exceptions properly*/
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