package com.prosigmaka.SpringSecurity.controller.async;

import com.prosigmaka.SpringSecurity.model.async.Order;
import com.prosigmaka.SpringSecurity.service.async.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class AsyncOrderController {
    private final AsyncService asyncService;

    @PostMapping("/")
    public ResponseEntity<Order> processOrder(@RequestBody Order order) throws InterruptedException{
        asyncService.processOrder(order); //synchronous

        asyncService.notifyUser(order); //asynchronous
        asyncService.assignVendor(order);
        asyncService.packaging(order);
        asyncService.assignDelivery(order);
        asyncService.assignTrailer(order);
        return ResponseEntity.ok(order);
    }
}
