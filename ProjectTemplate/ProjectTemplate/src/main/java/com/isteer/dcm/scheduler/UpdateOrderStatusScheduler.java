package com.isteer.dcm.scheduler;

import com.isteer.dcm.repository.OrderRepository;
import com.isteer.dcm.service.OrderStatusService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderStatusScheduler {

    Logger logger= LoggerFactory.getLogger(UpdateOrderStatusScheduler.class);
    @Autowired
    private OrderRepository ordersRepository;

    @Autowired
    private OrderStatusService orderStatusService;

    @Scheduled(fixedRateString = "${checkStatus.time.interval}")

   public void scheduleOrderStatusCheck() {
        orderStatusService.getOrderStatus();
        logger.info("Scheduled order status check completed.");
    }
}
