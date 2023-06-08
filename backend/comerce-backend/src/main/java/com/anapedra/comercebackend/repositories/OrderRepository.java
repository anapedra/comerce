package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
