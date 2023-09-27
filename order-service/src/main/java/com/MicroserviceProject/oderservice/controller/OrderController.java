package com.MicroserviceProject.oderservice.controller;

import com.MicroserviceProject.oderservice.dto.OrderRequest;
import com.MicroserviceProject.oderservice.service.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        orderService.placeOrder(orderRequest);
        return  "Order Place Successfully";
    }
    public String fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException)
    {
        return  "Oops! Lỗi rồi";
    }

}
