package com.project.paymentgateway.payment.service;

import com.project.paymentgateway.payment.dto.request.CreateOrderRequest;
import com.project.paymentgateway.payment.dto.response.OrderResponse;

public interface OrderService  {
    OrderResponse create(CreateOrderRequest request);
}
