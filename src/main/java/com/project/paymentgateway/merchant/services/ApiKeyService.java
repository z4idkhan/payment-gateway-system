package com.project.paymentgateway.merchant.services;

import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyCreateResponse;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchId);

    void revoke(UUID merchantId, UUID keyId);
}
