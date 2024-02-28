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

import java.security.Timestamp;
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
        //  List<String> emailList;
        try {
            List<String> statusList = List.of(DCMConstants.ORDERSTATUS_PLACED, DCMConstants.ORDERSTATUS_INPROGRESS, DCMConstants.ORDERSTATUS_SHIPPED);
            List<OrdersTable> ordersList = orderRepository.findByOrderStatusIn(statusList);

            if (ordersList == null || ordersList.isEmpty()) {
                logger.warn("No orders found for processing.");
                return;
            }

            List<OrdersTable> placedOrders = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_PLACED)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 1)
                    .collect(Collectors.toList());
         /*  List<OrdersTable> placedOrders = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_PLACED)
                    && calculateTimeDifference(p.getUpdatetime().toLocalDateTime(), LocalDateTime.now()) > 3)
                    .collect(Collectors.toList());*/

            if (!placedOrders.isEmpty()) {
                placedOrders.forEach(order -> {
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_INPROGRESS);
                });

                orderRepository.saveAll(placedOrders);

                sendEmailToDistributors("ravi.narayanaswamy@isteer.com", "ORDER INPROGRESS",
                        "Your order is now in progress.");
            }


           /* List<OrdersTable> inProgressOrder = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_INPROGRESS)
                    && calculateTimeDifference(p.getUpdatetime().toLocalDateTime(), LocalDateTime.now()) > 6).collect(Collectors.toList());
*/

            List<OrdersTable> inProgressOrder = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_INPROGRESS)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 2).collect(Collectors.toList());

            if (!inProgressOrder.isEmpty()) {
                inProgressOrder.forEach(order -> {
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_SHIPPED);
                });
                orderRepository.saveAll(inProgressOrder);
                sendEmailToDistributors("ravi.narayanaswamy@isteer.com", "ORDER SHIPPED",
                        "Your order is now shipped.");
            }

           /* List<OrdersTable> shippedOrders = ordersList.stream().filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_SHIPPED)
                    && calculateTimeDifference(p.getUpdatetime().toLocalDateTime(), LocalDateTime.now()) > 24).collect(Collectors.toList());*/

            List<OrdersTable> shippedOrders = ordersList.stream()
                    .filter(p -> p.getOrderStatus().equals(DCMConstants.ORDERSTATUS_SHIPPED)
                            && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 3)
                    .collect(Collectors.toList());
            if (!shippedOrders.isEmpty()) {
                shippedOrders.forEach(order -> {
                    order.setOrderStatus(DCMConstants.ORDERSTATUS_COMPLETED);
                });
                orderRepository.saveAll(shippedOrders);
                sendEmailToDistributors("ravi.narayanaswamy@isteer.com", "ORDER COMPLETED",
                        "Your order is completed.");
            }
        } catch (Exception e) {
            logger.error("Error while processing orders.", e);
            throw e;
        }

    }

    private long calculateTimeDifference(LocalDateTime updateTime, LocalDateTime currentTime) {
        Duration duration = Duration.between(updateTime, currentTime);
        return duration.toSeconds();
    }

    private void sendEmailToDistributors(String emailList, String subject, String body) {
        //  for (String toEmail : emailList) {
        dcmUtility.sendEmail(emailList, subject, createHtmlBody(body));
        //}
    }
    public static String createHtmlBody(String emailBody) {
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<h2>"+emailBody+"</h2>" +
                "<p>DEAR DISTRIBUTOR</p>" +
                // "<p>YOUR ORDER HAS BEEN  AND WILL BE MOVED TO STATE SHORTLY. YOU WILL BE UPDATED WHENEVER THERE IS ANY PROGRESS.</p>" +
                "<p>Your order has been processed and will be moved to the next state shortly. " +
                "You will be updated whenever there is any progress.</p>" +
                "<p>Regards</p>" +"<p>TEAM DCM</p>" +
                //   "<img src=\"https://drive.google.com/file/d/1r3MzGCUmJa_321c9MTkkvZCFXL9coDfB/view?usp=drive_link\" alt=\"Example Image\" style=\"width: 200px; height: auto;\">" +
                "<img src=\"https://drive.google.com/uc?id=1AOOD_7ESpPQPDCqSmW1WTv6Hs00_BU3Q\" alt=\"Company Logo\" style=\"width: 200px; height: auto;\">" +
                "</body>" +
                "</html>";
    }
}



