package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SaleDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long orderId;
    private Double amount;
    private LocalDate orderDate;

    public SaleDTO() {

    }

    public SaleDTO(Order entity) {
       orderId = entity.getId();
       amount= entity.getTotalPayment();
       orderDate =entity.getDateOrder();
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }
}






