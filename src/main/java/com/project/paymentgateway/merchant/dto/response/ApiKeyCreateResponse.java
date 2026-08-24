package com.project.paymentgateway.merchant.dto.response;

import com.project.paymentgateway.common.enums.Environment;

import java.util.UUID;

public record ApiKeyCreateResponse(
        UUID id,
        String keyId,
        String keySecret,
        Environment environment
) {
}