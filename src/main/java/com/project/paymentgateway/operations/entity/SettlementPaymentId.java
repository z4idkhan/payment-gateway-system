package com.project.paymentgateway.operations.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Embeddable
@EqualsAndHashCode
public class SettlementPaymentId {

    private UUID settlementId;

    private UUID paymentId;

}
