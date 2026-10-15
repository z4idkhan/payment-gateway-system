package com.project.paymentgateway.payment.service;

import com.project.paymentgateway.payment.dto.request.CreateOrderRequest;
import com.project.paymentgateway.payment.dto.response.OrderResponse;
import com.project.paymentgateway.payment.dto.response.PaymentResponse;

import java.util.List;
import java.util.UUID;

public interface OrderService  {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);

    OrderResponse getByID(UUID merchantId, UUID orderId);

    OrderResponse cancel(UUID merchantId, UUID orderId);

    List<PaymentResponse> getPayments(UUID merchantId, UUID orderId);

}
