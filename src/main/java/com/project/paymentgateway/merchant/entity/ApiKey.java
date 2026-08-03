package com.project.paymentgateway.merchant.entity;

import com.project.paymentgateway.common.enums.Environment;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "api_keys")
public class ApiKey {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = jakarta.persistence.FetchType.LAZY)
    @JoinColumn(name = "merchant_id")
    private Merchant merchant;

    @Column(unique = true, nullable = false, length = 200)
    private String keyId;

    @Column(nullable = false, length = 200)
    private String keySecretHash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Environment environment;

    @Column(nullable = false)
    private boolean enabled = true;


    private java.time.LocalDateTime lastUsedAt;
    private java.time.LocalDateTime rotatedAt;
    private java.time.LocalDateTime getPeriodExpiresAt;

}
