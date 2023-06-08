package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.OrderItem;
import com.anapedra.comercebackend.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
