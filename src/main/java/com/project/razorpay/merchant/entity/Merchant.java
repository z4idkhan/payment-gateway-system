package com.project.razorpay.merchant.entity;

import com.project.razorpay.common.enums.BusinessType;
import com.project.razorpay.common.enums.MerchantStatus;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "merchant")

public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NAME", nullable = false, length = 200)
    private String name;

    @Column(unique = true, length = 200)
    private String email;

    @Column(length = 20)
    private String contactNumber;

    @Column(name = "BUSINESS_TYPE", length = 50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;

    @Column(length = 100)
    private String businessName;

    @Column(length = 200)
    private String websiteUrl;

    @Column(nullable = false,length = 200)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status;

    @Column(length = 20)
    private String gstId;

    @Column(length = 200)
    private String panId;

    @Column(length = 20)
    private String settelmentBankAccount;

    @Column(length = 20)
    private String settelmentBankIfsc;

    @Column(length = 200)
    private String settelmentBankAccountHolderName;

}
