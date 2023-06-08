package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
