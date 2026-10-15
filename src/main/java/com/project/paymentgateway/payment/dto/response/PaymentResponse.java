package com.project.paymentgateway.payment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.paymentgateway.common.enums.PaymentMethod;
import com.project.paymentgateway.common.enums.PaymentStatus;
import com.project.paymentgateway.common.entity.Money;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record PaymentResponse(
        UUID id,
        UUID orderId,
        UUID merchantId,
        Money amount,
        PaymentStatus status,
        PaymentMethod method,
        Map<String, Object> methodDetails,
        String errorCode,
        String errorDescription,
        LocalDateTime capturedAt,
        LocalDateTime createdAt
) {

}