package com.project.paymentgateway.payment.dto.request;

import com.project.paymentgateway.common.entity.Money;

import java.time.LocalDateTime;
import java.util.Map;

public record CreateOrderRequest(
        Money amount,

        String receipt,

        Map<String, Object> notes,

        LocalDateTime expiresAt

) {
}
