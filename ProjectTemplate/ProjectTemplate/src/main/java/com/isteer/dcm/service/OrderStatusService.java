package com.isteer.dcm.service;

import com.isteer.dcm.constants.DCMConstants;
import com.isteer.dcm.entity.DcmUsers;
import com.isteer.dcm.entity.OrdersTable;
import com.isteer.dcm.repository.OrderRepository;
import com.isteer.dcm.utility.DcmUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderStatusService {

    private static final Logger logger = LoggerFactory.getLogger(OrderStatusService.class);

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    private DcmUtility dcmUtility;

    @Autowired
    OnstartupDataInitializer dataInitializer;

    private List<String> orderPlacedByList;
    private final Map<Long, Boolean> emailSentMap = new HashMap<>();

    public void getOrderStatus() {
       List<String> emailList;
        try {
            List<String> statusList = List.of(DCMConstants.ORDERSTATUS_PLACED, DCMConstants.ORDERSTATUS_INPROGRESS, DCMConstants.ORDERSTATUS_SHIPPED);
            List<OrdersTable> ordersList = orderRepository.findByOrderStatusIn(statusList);
            if (ordersList == null || ordersList.isEmpty()) {
                logger.warn("No orders found for processing.");
                return;
            }
            List<DcmUsers> userData = dataInitializer.getDcmUsersList();


            orderPlacedByList = ordersList.stream().map(OrdersTable::getOrderplaced_by).collect(Collectors.toList());

            emailList = userData.stream().filter(DcmUser -> orderPlacedByList.contains(DcmUser.getUserName()))
                    .map(DcmUsers::getUserEmail).collect(Collectors.toList());

            List<OrdersTable> placedOrders = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_PLACED)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 3)
                    .collect(Collectors.toList());


            for (OrdersTable order : placedOrders) {
                Long orderId = order.getOrder_id().longValue();
                if (!emailSentMap.containsKey(orderId) || !emailSentMap.get(orderId)) {
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_INPROGRESS);
                    orderRepository.save(order);
                    sendEmailToDistributors(emailList, "Order Status Update", "Your order is now in progress.");

                    emailSentMap.put(orderId, true);
                }
            }



            List<OrdersTable> inProgressOrder = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_INPROGRESS)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 6).collect(Collectors.toList());
            Set<String> processedEmails = new HashSet<>();

            try{
            inProgressOrder.forEach(order -> {
                order.setOrderStatus(DCMConstants.ORDERSTATUS_SHIPPED);
                String email = order.getOrderplaced_by(); // Assuming orderplaced_by is the email address
                if (!processedEmails.contains(email)) {
                    processedEmails.add(email);

                    // Save the order with updated status
                    orderRepository.save(order);

                    // Send email only if it's a unique email
                    if (!processedEmails.contains(email)) {
                        sendEmailToDistributors(Collections.singletonList(email),
                                "Order Status Update", "Your order is Shipped.");
                    }
                }
            });
            } catch (Exception e) {
                logger.error("Error updating orders to Shipped status or sending emails: " + e.getMessage(), e);
                // Handle the exception or rethrow based on your requirements.
            }
          /*  });
          orderRepository.saveAll(inProgressOrder);

            sendEmailToDistributors(emailList, "Order Status Update", "Your order is Shipped.");

*/

            Set<String> processedEmailsShipped = new HashSet<>();
            try {
                List<OrdersTable> shippedOrders = ordersList.stream()
                        .filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_SHIPPED)
                                && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 24)
                        .collect(Collectors.toList());

                shippedOrders.forEach(order -> {
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_COMPLETED);

                    // Check if the email has already been processed
                    String email = order.getOrderplaced_by();
                    if (!processedEmailsShipped.contains(email)) {
                        processedEmailsShipped.add(email);

                        // Save the order with updated status
                        orderRepository.save(order);

                        // Send email only if it's a unique email
                        if (!processedEmailsShipped.contains(email)) {
                            sendEmailToDistributors(Collections.singletonList(email),
                                    "Order Status Update", "Your order has been completed.");
                        }
                    }
                });
            } catch (Exception e) {
                logger.error("Error updating orders to Completed status or sending emails for shipped orders: " + e.getMessage(), e);
                // Handle the exception or rethrow based on your requirements.
            }

          /*  List<OrdersTable> shippedOrders = ordersList.stream().filter(p -> p.getOrder_status().equals(DCMConstants.ORDERSTATUS_SHIPPED)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 24).collect(Collectors.toList());

            shippedOrders.forEach(order -> {
                order.setOrder_status(DCMConstants.ORDERSTATUS_COMPLETED);
            });
            orderRepository.saveAll(shippedOrders);

            sendEmailToDistributors(emailList, "Order Status Update", "Your order has been completed.");
*/
        } catch (Exception e) {
            logger.error("Error while processing orders.", e);
        }

    }

    private long calculateTimeDifference(LocalDateTime updateTime, LocalDateTime currentTime) {
        Duration duration = Duration.between(updateTime, currentTime);
        return duration.toHours();
    }

    private void sendEmailToDistributors(List<String> emailList, String subject, String body) {
        for (String toEmail : emailList) {
            dcmUtility.sendEmail(toEmail, subject, body);
        }
    }
}



