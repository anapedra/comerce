package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {
}
