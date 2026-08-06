package com.project.paymentgateway.merchant.controller;

import com.project.paymentgateway.merchant.dto.request.MerchantSignupRequest;
import com.project.paymentgateway.merchant.dto.response.MerchantResponse;
import com.project.paymentgateway.merchant.services.AuthServiceInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/auth")
@RequiredArgsConstructor
public class AuthController {

private final AuthServiceInterface service;

    @PostMapping("/signup")
    public ResponseEntity<MerchantResponse> signup(
            @RequestBody @Valid MerchantSignupRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.signup(request));
    }

}
