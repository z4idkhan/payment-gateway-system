package com.project.paymentgateway.merchant.services;

import com.project.paymentgateway.merchant.dto.request.MerchantSignupRequest;
import com.project.paymentgateway.merchant.dto.response.MerchantResponse;

public interface AuthServiceInterface {
    MerchantResponse signup(MerchantSignupRequest request);
}
