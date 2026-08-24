package com.project.paymentgateway.merchant.dto.request;

import com.project.paymentgateway.common.enums.Environment;

public record CreateApiKeyRequest(
        Environment environment
) {
}
