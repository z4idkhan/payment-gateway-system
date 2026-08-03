package com.project.paymentgateway.merchant.services.impl;
import com.project.paymentgateway.common.enums.MerchantStatus;
import com.project.paymentgateway.merchant.dto.request.MerchantSignupRequest;
import com.project.paymentgateway.merchant.dto.response.MerchantResponse;
import com.project.paymentgateway.merchant.entity.Merchant;
import com.project.paymentgateway.merchant.repository.AppUserRepository;
import com.project.paymentgateway.merchant.repository.MerchantRepository;
import com.project.paymentgateway.merchant.services.AuthServiceInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class AuthServiceImpl implements AuthServiceInterface {

    @Autowired
    AppUserRepository appUserRepo;

    @Autowired
    MerchantRepository merchRepo;


    @Override
    public MerchantResponse signup(MerchantSignupRequest request) {

        if(merchRepo.existsByEmail(request.email())){
            throw new RuntimeException("Merchant with Email Already exist" + request.email());
        }

        Merchant merchant = Merchant.builder()
                .businessName(request.businessName())
                .businessType(request.businessType())
                .name(request.name())
                .email(request.email())
                .status(MerchantStatus.PENDING_KYC)
                .build();

        return null;
    }
}
