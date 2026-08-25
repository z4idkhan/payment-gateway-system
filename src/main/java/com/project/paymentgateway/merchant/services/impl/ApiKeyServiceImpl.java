package com.project.paymentgateway.merchant.services.impl;

import com.project.paymentgateway.common.exception.ResourceNotFoundException;
import com.project.paymentgateway.common.util.RandomizerUtil;
import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyCreateResponse;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;
import com.project.paymentgateway.merchant.entity.ApiKey;
import com.project.paymentgateway.merchant.entity.Merchant;
import com.project.paymentgateway.merchant.repository.ApiKeyRepository;
import com.project.paymentgateway.merchant.repository.MerchantRepository;
import com.project.paymentgateway.merchant.services.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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
    public ApiKeyCreateResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchrepo.findById(merchantId)
                .orElseThrow(()->new ResourceNotFoundException("merchant with id: ", merchantId));

        String keyId = "rzp_" + request.environment().name().toLowerCase() + "_" + RandomizerUtil.randomBase64(24);
        String rawSecret = RandomizerUtil.randomBase64(48);

        ApiKey apiKey = ApiKey.builder()
                .keyId(keyId)
                .keySecretHash(rawSecret)
                .environment(request.environment())
                .merchant(merchant)
                .build();

        apiKey = apirepo.save(apiKey);

        return new ApiKeyCreateResponse(apiKey.getId(), keyId, rawSecret, request.environment());
    }

    @Override
    public List<ApiKeyResponse> listByMerchant(UUID merchId) {
        return apirepo.findByMerchant_Id(merchId).stream()
                .map(ak -> new ApiKeyResponse(
                        ak.getId(),
                        ak.getKeyId(),
                        ak.getEnvironment(),
                        ak.isEnabled(),
                        ak.getLastUsedAt(),null ))
                .toList();
    }

    @Override
    public void revoke(UUID merchantId, UUID keyId) {
        ApiKey key = apirepo.findById(keyId)
                .filter(k -> k.getMerchant().getId().equals(merchantId))
                .orElseThrow(() -> new ResourceNotFoundException("API key with id: ", keyId));
        key.setEnabled(false);
    }

    @Override
    public ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId) {
        ApiKey key = apirepo.findById(keyId)
                .filter(k -> k.getMerchant().getId().equals(merchantId))
                .orElseThrow(() -> new ResourceNotFoundException("API key with id: ", keyId));

        return null;
    }
}
