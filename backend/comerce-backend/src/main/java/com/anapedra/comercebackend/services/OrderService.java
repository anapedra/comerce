package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.dtos.OrderDTO;
import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository repository;
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }


    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Optional<Order> result = repository.findById(id);
        Order entity = result.get();
        return new OrderDTO(entity,entity.getItems());
    }
    @Transactional(readOnly = true)
    public Page<OrderDTO> findAllSale(Pageable pageable){
        Page<Order> page=repository.findAll(pageable);
        return page.map(OrderDTO::new);
    }
}
