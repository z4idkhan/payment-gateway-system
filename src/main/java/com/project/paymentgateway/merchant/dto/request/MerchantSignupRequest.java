package com.project.paymentgateway.merchant.dto.request;

import com.project.paymentgateway.common.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignupRequest(
        @NotNull(message = "Name is required")
        @Size(max = 50, message = "Name must be of 50 Charecters")
        String name,

        @Email
        @NotNull(message = "Email Required to be Filled")
        String email,

        @NotNull(message = "PLease Ebnter Your Password")
        @Size(min=8,message = "Password Must be of 8 Charecters")
        String password,

        @Size(max =50, message = "It should be of 50 Charecters")
        String businessName,

        BusinessType businessType
){
}
