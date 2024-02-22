package com.isteer.dcm.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.UserRoles;
import com.isteer.dcm.model.OrderRequest;
import com.isteer.dcm.model.OrderResponse;
//import com.isteer.dcm.service.OrderService;
import com.isteer.dcm.model.ProductReviewRoot;
import com.isteer.dcm.model.RatingReviewResponse;
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
    public @ResponseBody ProductReviewRoot getRatingsAndReviews(@RequestParam Integer sellerId) {
        ProductReviewRoot productReviewRoot = new ProductReviewRoot();
        try {
            List<UserRoles> dcmUsers = onstartupDataInitializer.getUserRoles().stream()
                    .filter(p -> (p.getRoleId() == sellerId && p.getRoleName().equalsIgnoreCase(DCMConstants.USER_MANUFACTURER)))
                    .collect(Collectors.toList());

            if (dcmUsers.isEmpty()) {
                productReviewRoot.setResponseCode(DCMConstants.Forbidden);
                productReviewRoot.setResponseMessage(DCMConstants.INVALID_USER);
            } else {
                //UserRoles userRole = dcmUsers.get(0);
                for (UserRoles userRole : dcmUsers) {
                    if(userRole.isViewRatingandReview().equals("N"))   {
                        productReviewRoot.setResponseCode(DCMConstants.ACCESS_DENIED);
                        productReviewRoot.setResponseMessage(DCMConstants.ACCESS_DENIED);
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
                }
            }
        } catch (Exception ex) {
            productReviewRoot.setResponseCode("203");
            productReviewRoot.setResponseMessage("EXCEPTION WAS THROWN");
        }
        return productReviewRoot;
    }


}