package com.isteer.dcm.service;

import com.isteer.dcm.compositekeys.ProductCompositeKey;
import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.OrdersTable;
import com.isteer.dcm.entity.Products;
import com.isteer.dcm.model.*;
import com.isteer.dcm.repository.OrderRepository;
import com.isteer.dcm.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest request) {
        OrderResponse response = new OrderResponse();
        List<OrderItem> orderItems = request.getPlaceOrder();
        List<OrderStatus> orderStatusList = new ArrayList<>();

        for (OrderItem item : orderItems) {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setUpc(item.getUpc().toString());

            // Fetch product by UPC
            Optional<Products> productOptional = productRepository.fetchByUpc(item.getUpc());

            if (productOptional.isPresent()) {
                Products product = productOptional.get();

                // Validate order size against inventory size
                if (item.getOrderSize().compareTo(product.getInventory_size().divide(BigDecimal.valueOf(2))) > 0) {
                    orderStatus.setOrderStatus(DCMConstants.ORDERSTATUS_ERROR + DCMConstants.INSUFFICIENT_INVENTORY);
                } else {
                    // Create order
                    OrdersTable order = new OrdersTable();
                    order.setOrderplaced_by(request.getDistributorId());
                    order.setProduct_id(item.getUpc().toString());
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_PLACED);
                    order.setUpdatetime(LocalDateTime.now());
                    order.setManufacturer_id(product.getSellerid());
                    orderRepository.save(order);

                    // Update inventory size
                    BigDecimal newInventorySize = product.getInventory_size().subtract(item.getOrderSize());
                    product.setInventory_size(newInventorySize);
                    productRepository.save(product);

                    orderStatus.setOrderStatus(DCMConstants.ORDERSTATUS_PLACED);
                }
            } else {
                orderStatus.setOrderStatus(DCMConstants.ORDERSTATUS_ERROR + DCMConstants.PRODUCT_NOT_FOUND);
            }

            orderStatusList.add(orderStatus);
        }

        response.setOrderStatusList(orderStatusList);
        return response;
    }

    public List<RatingReviewResponse> reveiwProducts(Integer sellerId) {
        List<RatingReviewResponse> productReviews = new ArrayList<>();
        try {
            //  List<Products> productsList2 = productRepository.findByInventorySize(1);
            List<Products> productsList = productRepository.findBySellerId(sellerId);
            if (!productsList.isEmpty() && productsList.size() > 0) {
                for (Products prod : productsList) {
                    RatingReviewResponse prdReview = new RatingReviewResponse();
                    prdReview.setUpc(String.valueOf(prod.getProductsCompositeKeys().getUpc()));
                    prdReview.setProductName(prod.getProduct_name());
                    prdReview.setRating(String.valueOf(prod.getRating()));
                    prdReview.setReview(prod.getUser_reviews());
                    productReviews.add(prdReview);
                }
            } else {
                throw new RuntimeException(DCMConstants.NO_UPCS_FOUND);
            }
        } catch (Exception excpetion) {
            excpetion.printStackTrace();
            throw excpetion;
        }
        return productReviews;
    }

}


