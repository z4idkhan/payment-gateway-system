package com.project.paymentgateway.merchant.controller;

import com.project.paymentgateway.merchant.dto.request.CreateApiKeyRequest;
import com.project.paymentgateway.merchant.dto.response.ApiKeyCreateResponse;
import com.project.paymentgateway.merchant.dto.response.ApiKeyResponse;
import com.project.paymentgateway.merchant.services.ApiKeyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/merchants/{merchantId}/api-keys")
@RequiredArgsConstructor
public class ApiKeyController {

    @Autowired
    ApiKeyService apiKeyService;

    @PostMapping
    public ResponseEntity<ApiKeyCreateResponse> create(@PathVariable UUID merchantId,
                                                       @Valid @RequestBody CreateApiKeyRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(apiKeyService.create(merchantId,request));
    }

    @GetMapping
    public ResponseEntity<List<ApiKeyResponse>> listByMerchant(@PathVariable UUID merchantId) {
        return ResponseEntity.ok(apiKeyService.listByMerchant(merchantId));
    }

    @DeleteMapping
    public ResponseEntity<Void> revoke(@PathVariable UUID merchantId, @PathVariable UUID keyId){
        apiKeyService.revoke(merchantId, keyId);
        return ResponseEntity.noContent().build();
    }

}
