package com.anapedra.comercebackend.services;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.OrderItem;
import com.anapedra.comercebackend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcSale {
    private final OrderRepository orderRepository;
    public CalcSale(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public double getCalcSale(){
        List<Order>orders=new ArrayList<>();
            double soma = 0.0;
            for (Order order : orders) {
                soma += order.getTotal();
            }
            return soma;

    }
}
