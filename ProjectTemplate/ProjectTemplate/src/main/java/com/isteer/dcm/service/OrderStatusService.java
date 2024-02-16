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
import java.util.List;
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
    private List<String> emailList;

    public void getMailId() {
        List<DcmUsers> userData = dataInitializer.getDcmUsersList();

        //getOrderStatus();
        emailList = userData.stream().filter(DcmUser -> orderPlacedByList.contains(DcmUser.getUsername()))
                .map(DcmUsers::getUser_email).collect(Collectors.toList());
    }

    public void getOrderStatus() {
        try {
            List<String> statusList = List.of(DCMConstants.ORDERSTATUS_PLACED, DCMConstants.ORDERSTATUS_INPROGRESS, DCMConstants.ORDERSTATUS_SHIPPED);
            List<OrdersTable> ordersList = orderRepository.findByOrderStatusIn(statusList);
            if (ordersList == null || ordersList.isEmpty()) {
                logger.warn("No orders found for processing.");
                return;
            }
            orderPlacedByList = ordersList.stream().map(OrdersTable::getOrderplaced_by).collect(Collectors.toList());

            LocalDateTime now = LocalDateTime.now();

            List<OrdersTable> placedOrders = ordersList.stream().filter(p -> p.getOrder_status().equals(DCMConstants.ORDERSTATUS_PLACED)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 3)
                    .collect(Collectors.toList());
            placedOrders.forEach(order -> { order.setOrder_status(DCMConstants.ORDERSTATUS_INPROGRESS); });
            orderRepository.saveAll(placedOrders);

            sendEmailToDistributors(emailList, "Order Status Update", "Your order is now in progress.");

            List<OrdersTable> inProgressOrder = ordersList.stream().filter(p -> p.getOrder_status().equals(DCMConstants.ORDERSTATUS_INPROGRESS)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 6).collect(Collectors.toList());


            inProgressOrder.forEach(order -> {
                order.setOrder_status(DCMConstants.ORDERSTATUS_SHIPPED);
            });
            orderRepository.saveAll(inProgressOrder);

            List<OrdersTable> shippedOrders = ordersList.stream().filter(p -> p.getOrder_status().equals(DCMConstants.ORDERSTATUS_SHIPPED)
                    && calculateTimeDifference(p.getUpdatetime(), LocalDateTime.now()) > 24).collect(Collectors.toList());

            shippedOrders.forEach(order -> {
                order.setOrder_status(DCMConstants.ORDERSTATUS_COMPLETED);
            });
            orderRepository.saveAll(shippedOrders);
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



