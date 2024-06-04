package com.myprojects.spring_transatcional.repository;

import com.myprojects.spring_transatcional.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
