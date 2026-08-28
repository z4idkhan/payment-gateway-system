package com.project.paymentgateway.payment.controller;

import com.project.paymentgateway.payment.dto.request.CreateOrderRequest;
import com.project.paymentgateway.payment.dto.response.OrderResponse;
import com.project.paymentgateway.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> create(@RequestBody CreateOrderRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(orderService.create(request));
    }

}
