package com.project.paymentgateway.payment.repository;

import com.project.paymentgateway.payment.entity.OrderRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderRecord, UUID> {
}
