package com.project.paymentgateway.merchant.services.impl;

import com.project.paymentgateway.common.exception.ResourceNotFoundException;
import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;
import com.project.paymentgateway.merchant.entity.ApiKey;
import com.project.paymentgateway.merchant.entity.Merchant;
import com.project.paymentgateway.merchant.repository.ApiKeyRepository;
import com.project.paymentgateway.merchant.repository.MerchantRepository;
import com.project.paymentgateway.merchant.services.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApiKeyServiceImpl implements ApiKeyService {

    @Autowired
    MerchantRepository merchrepo;

    @Autowired
    ApiKeyRepository apirepo;

    @Override
    public ApiKeyResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchrepo.findById(merchantId)
                .orElseThrow(()->new ResourceNotFoundException("merchant with id: ", merchantId));
        String keyId = "rzp"+request.environment().name().toUpperCase()+"big_random_String";
        String rawSecret ="big_random_sseret" ; //TODO: replace with cruptographic random HEX

        ApiKey apiKey = ApiKey.builder()
                .keyId(keyId)
                .keySecretHash(rawSecret)
                .environment(request.environment())
                .merchant(merchant)
                .build();

        apiKey = apirepo.save(apiKey);

        return new ApiKeyResponse(apiKey.getId(), keyId, rawSecret, request.environment());
    }
}
