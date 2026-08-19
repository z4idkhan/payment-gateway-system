package com.project.paymentgateway.merchant.dto.response;

import java.util.UUID;

public record ApiKeyResponse(
        UUID id,
        String keyId,
        String keySecret,
        String environment
) {
}