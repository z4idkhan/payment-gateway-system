package com.project.razorpay.payment.entity;

import com.project.razorpay.common.Money;
import com.project.razorpay.common.enums.PaymentMethod;
import com.project.razorpay.common.enums.PaymentStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,optional = false )
    @JoinColumn(name = "order_id",nullable = false)
    private OrderRecord order;

    @Column(nullable = false)
    private  UUID merchantId;

    @Embedded
    private Money amount;

    @Column(nullable = false,length = 20)
    private String idempotency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false,length = 20)
    private PaymentStatus status;

    @Column(nullable = false)
    private PaymentMethod method;

    @JdbcTypeCode((SqlTypes.JSON))
    @Column(name = "method_details",columnDefinition = "jsonb")
    private Map<String, Object> methodDetails;

    @Column(length = 200)
    private String bankReference;

    @Column(length = 200)
    private String errorCode;

    @Column(length = 200)
    private String errorDescription;

    private LocalDateTime authorizedAt;

    private LocalDateTime capturedAt;

    private LocalDateTime failedAt;

    private LocalDateTime refundedAt;

}
