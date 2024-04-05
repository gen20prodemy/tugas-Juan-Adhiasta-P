package com.prosigmaka.SpringSecurity.service.async;

import com.prosigmaka.SpringSecurity.model.async.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentService {

    public void processPayment(Order order) throws InterruptedException{
        log.info("initiate payment for order "+order.getProductId());
        Thread.sleep(2000L);
        log.info("completed payment for order "+order.getProductId());
    }
}
