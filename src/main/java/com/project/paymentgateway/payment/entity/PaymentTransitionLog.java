package com.project.paymentgateway.payment.entity;

import com.project.paymentgateway.common.enums.PaymentActor;
import com.project.paymentgateway.common.enums.PaymentEvent;
import com.project.paymentgateway.common.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payment_transition_log")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PaymentTransitionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;

    @Enumerated(EnumType.STRING)
    @Column(name = "from_status", length = 30)
    private PaymentStatus fromStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", nullable = false, length = 30)
    private PaymentEvent event;

    @Enumerated(EnumType.STRING)
    @Column(name = "to_status", nullable = false, length = 30)
    private PaymentStatus toStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "actor", length = 100)
    private PaymentActor actor;

    @Column(name = "occurred_at", nullable = false)
    private LocalDateTime occurredAt;
}