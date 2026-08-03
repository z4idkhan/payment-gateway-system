package com.project.paymentgateway.merchant.dto.response;

import com.project.paymentgateway.common.enums.BusinessType;
import com.project.paymentgateway.common.enums.MerchantStatus;

import java.util.UUID;

public record MerchantResponse(
        UUID id,
        String name,
        String email,
        String businessName,
        BusinessType businessType,
        MerchantStatus merchantStatus
) {
}