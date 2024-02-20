package com.isteer.dcm.service;

import com.isteer.dcm.compositekeys.ProductCompositeKey;
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

        for (OrderItem item : orderItems) {

            ProductCompositeKey productCompositeKey = new ProductCompositeKey();
            productCompositeKey.setUpc(BigDecimal.valueOf(1234567890));
            productCompositeKey.setStore_Id(BigDecimal.valueOf(123));
           Optional<Products> product1 = productRepository.findById(productCompositeKey);
           Products product = product1.get();
            if (product == null) {
                response.setResponseCode(DCMConstants.NOT_FOUND);
                response.setResponseMessage("Product not found");
                return response;
            }

            if (item.getOrderSize().intValue() > (product.getInventory_size()).intValue() / 2) {
                response.setResponseCode(DCMConstants.BAD_REQUEST);
                response.setResponseMessage("Inventory size not sufficient for order");
                return response;
            }


            // Create order
            OrdersTable order = new OrdersTable();
            order.setOrderplaced_by(item.getDistributorId());
            order.setProduct_id("");
            order.setOrderStatus(OrderResponse.orderStatus); // assuming 1 for placed status
            order.setUpdatetime(LocalDateTime.now());
            order.setManufacturer_id(product.getSellerid());
            orderRepository.save(order);


            // Update inventory size
            BigDecimal newInventorySize = product.getInventory_size().subtract(item.getOrderSize());
            product.setInventory_size(newInventorySize);
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


