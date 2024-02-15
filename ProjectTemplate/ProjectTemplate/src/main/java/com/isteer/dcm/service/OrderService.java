package com.isteer.dcm.service;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.OrdersTable;
import com.isteer.dcm.entity.Products;
import com.isteer.dcm.model.OrderItem;
import com.isteer.dcm.model.OrderRequest;
import com.isteer.dcm.model.OrderResponse;
import com.isteer.dcm.repository.OrderRepository;
import com.isteer.dcm.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest request) {
        OrderResponse response = new OrderResponse();
        List<OrderItem> orderItems = request.getPlaceOrder();

        for (OrderItem item : orderItems) {
            Products product = productRepository.findById(item.getUpc()).orElse(null);
            if (product == null) {
                response.setResponseCode(DCMConstants.NOT_FOUND);
                response.setResponseMessage("Product not found");
                return response;
            }

            if (item.getOrderSize() > product.getInventorySize() / 2) {
                response.setResponseCode(DCMConstants.BAD_REQUEST);
                response.setResponseMessage("Inventory size not sufficient for order");
                return response;
            }


            // Create order
            OrdersTable order = new OrdersTable();
            order.setOrder_PlacedBy(item.getDistributorId());
            order.setProduct_Id(item.getUpc());
            order.setOrder_Status(OrderResponse.orderStatus); // assuming 1 for placed status
            order.setUpdate_Time(LocalDateTime.now());
            order.setManufacturer_Id(product.getSellerId());
            orderRepository.save(order);


            // Update inventory size
            product.setInventorySize(product.getInventorySize() - item.getOrderSize());
            productRepository.save(product);
        }

        response.setResponseCode(DCMConstants.SUCCESS);
        response.setResponseMessage("Order placed successfully");
        response.setOrderStatus("Placed");
        return response;
    }

    public OrderResponse placeOrder(String distributorId, String productId, String upc) {
        return null;
    }
}


