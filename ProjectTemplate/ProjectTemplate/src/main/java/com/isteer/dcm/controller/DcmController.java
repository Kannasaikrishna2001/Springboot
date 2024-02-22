package com.isteer.dcm.controller;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.UserRoles;
import com.isteer.dcm.model.*;
import com.isteer.dcm.service.OnstartupDataInitializer;
import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.service.ReviewAndRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dcm")
public class DcmController {

    private static final Logger logger = LoggerFactory.getLogger(DcmController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReviewAndRating reviewAndRating;

    @Autowired
    OnstartupDataInitializer onstartupDataInitializer;
    /*
         * revisit the order response as it will not work in case if order is placed for multiple upcs
         * each upc should have its status separately , whether the order is placed for that very upc or not
         * consider restructuring the response model by keeping upc and order status as two elements inside a child model which it iterative and have one root model class as the response
         * the code will not work in all of the below scenarios
         * 1: when one of the upcs is present and one or more is not
         * 2: Validate the manufacturerid
         * */
    @PostMapping("/place-order")
    public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        try {
            // Log the received request for debugging purposes
            logger.info(DCMConstants.ORDER_REQUEST, request);

            OrderResponse response = orderService.placeOrder(request);

            if (response != null) {
                List<OrderStatus> orderStatusList = response.getOrderStatusList();
                for (OrderStatus orderStatus : orderStatusList) {
                    if (DCMConstants.ORDERSTATUS_PLACED.equals(orderStatus.getOrderStatus())) {
                        // Log successful order placement
                        logger.info("{} {}, product: {}, UPC: {}, Status: {}",
                                DCMConstants.ORDER_MSG_SUCCESS, request.getDistributorId(), orderStatus.getUpc(), orderStatus.getOrderStatus());
                    } else {
                        // Log failed order placement
                        logger.error("{}, product: {}, UPC: {}, Error: {}",
                                DCMConstants.ORDERSTATUS_ERROR, request.getDistributorId(), orderStatus.getUpc(), orderStatus.getOrderStatus());
                    }
                }
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error(DCMConstants.ORDERSTATUS_ERROR, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

  /*  @GetMapping(value = "/ratings-reviews")
    public ProductReviewRoot getRatingsAndReviews(@RequestParam int sellerid) {

        ProductReviewRoot productReviewRoot = reviewAndRating.sellerValidation(sellerid);
       // Products product = reviewAndRating.getProductBySellerId(BigDecimal.valueOf(sellerid));


                return ResponseEntity.ok(productReviewRoot);
            } else {
                return ResponseEntity.notFound().build();
            }

    }*/

    @GetMapping("/ratings-reviews")
    public @ResponseBody
    ProductReviewRoot getRatingsAndReviews(@RequestParam Integer sellerId) {
        ProductReviewRoot productReviewRoot = new ProductReviewRoot();
        try {
            List<UserRoles> dcmUsers = onstartupDataInitializer.getUserRoles().stream().filter
                    (p -> (p.getRoleId() == sellerId && p.getRoleName()
                            .equalsIgnoreCase(DCMConstants.USER_MANUFACTURER)))
                    .collect(Collectors.toList());
            if (dcmUsers.isEmpty()) {
                productReviewRoot.setResponseCode(DCMConstants.Forbidden);
                productReviewRoot.setResponseMessage(DCMConstants.INVALID_USER);
            } else {
                List<RatingReviewResponse> product = orderService.reveiwProducts(sellerId);
                if (!product.isEmpty()) {
                    productReviewRoot.setResponseCode(DCMConstants.SUCCESS);
                    productReviewRoot.setResponseMessage(DCMConstants.SUCCESS_RESP_MSG);
                    productReviewRoot.setRatingReviewResponses(product);
                } else {

                    productReviewRoot.setResponseCode(DCMConstants.SUCCESS);
                    productReviewRoot.setResponseMessage(DCMConstants.NO_DATA_FOUND);
                }
            }
        } catch (Exception ex) {
            productReviewRoot.setResponseCode("203");
            productReviewRoot.setResponseMessage("EXCEPTION WAS THROWN");
        }
        return productReviewRoot;
    }


}