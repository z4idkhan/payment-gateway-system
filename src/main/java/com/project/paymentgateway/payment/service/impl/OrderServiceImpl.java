package com.project.paymentgateway.payment.service.impl;

import com.project.paymentgateway.common.exception.DuplicateResourceException;
import com.project.paymentgateway.payment.dto.request.CreateOrderRequest;
import com.project.paymentgateway.payment.dto.response.OrderResponse;
import com.project.paymentgateway.payment.repository.OrderRepository;
import com.project.paymentgateway.payment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderResponse create(CreateOrderRequest request) {
        UUID merchantId = null;

        if (orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())) {
            throw new DuplicateResourceException("ORDER_WITH_THE_GIVEN_RECEIPT_ALREADY_EXISTS","Order with Reciept Already Exist");
        }

        return null;
    }
}