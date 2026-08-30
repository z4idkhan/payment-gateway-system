package com.project.paymentgateway.payment.service;

import com.project.paymentgateway.payment.dto.request.CreateOrderRequest;
import com.project.paymentgateway.payment.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService  {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
