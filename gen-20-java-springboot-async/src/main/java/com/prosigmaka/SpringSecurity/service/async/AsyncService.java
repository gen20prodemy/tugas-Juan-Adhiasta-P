package com.prosigmaka.SpringSecurity.service.async;

import com.prosigmaka.SpringSecurity.model.async.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncService {

    private final InventoryService inventoryService;

    private final PaymentService paymentService;

    public Order processOrder(Order order) throws InterruptedException{
        order.setTrackingId(UUID.randomUUID().toString());
        if(inventoryService.checkProduct(order.getProductId())){
            paymentService.processPayment(order);
        } else {
            throw new RuntimeException("Technical issue, please retry");
        }
        return order;
    }
    @Async("asyncTaskExecutor")
    public void notifyUser(Order order) throws InterruptedException{
        Thread.sleep(7000L);
        log.info("Notified to the user "+Thread.currentThread().getName());
    }
    @Async("asyncTaskExecutor")
    public void assignVendor(Order order) throws InterruptedException{
        Thread.sleep(8000L);
        log.info("Assign order to vendor "+Thread.currentThread().getName());
    }
    @Async("asyncTaskExecutor")
    public void packaging(Order order) throws InterruptedException{
        Thread.sleep(8000L);
        log.info("Order packaging completed "+Thread.currentThread().getName());
    }
    @Async("asyncTaskExecutor")
    public void assignDelivery(Order order) throws InterruptedException{
        Thread.sleep(10000L);
        log.info("Delivery partner assigned "+Thread.currentThread().getName());
    }
    @Async("asyncTaskExecutor")
    public void assignTrailer(Order order) throws InterruptedException{
        Thread.sleep(3000L);
        log.info("Trailer assigned and dispatch "+Thread.currentThread().getName());
    }
}
