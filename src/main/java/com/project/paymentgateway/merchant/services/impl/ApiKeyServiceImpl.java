package com.project.paymentgateway.merchant.services.impl;

import com.project.paymentgateway.common.exception.ResourceNotFoundException;
import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;
import com.project.paymentgateway.merchant.entity.Merchant;
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

    @Override
    public ApiKeyResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchrepo.findById(merchantId)
                .orElseThrow(()->new ResourceNotFoundException("merchant with id: " + merchantId + " not found"));
        return null;
    }
}
