package com.project.paymentgateway.merchant.services;

import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;

import java.util.UUID;

public interface ApiKeyService {

    ApiKeyResponse create(UUID merchantId, CreateApiKeyRequest request){

    }
}
