package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.OrderItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesClientDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String clientName;
    private LocalDate dateOrder;
    private Double total;
    private Integer quantityProduct;
    private List<OrderItemDTO> items=new ArrayList<>();


    public SalesClientDTO() {

    }

    public SalesClientDTO(Long id, String clientName, LocalDate dateOrder, Double total, Integer quantityProduct) {
        this.id = id;
        this.clientName = clientName;
        this.dateOrder = dateOrder;
        this.total = total;
        this.quantityProduct = quantityProduct;
    }

    public SalesClientDTO(Order entity) {
      id= entity.getId();
      clientName=entity.getClient().getName();
      quantityProduct=entity.getQuantityProduct();
      total=entity.getTotal();
    }

    public SalesClientDTO(Order entity,Set<OrderItem> orderItems){
        this(entity);
        entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }


}
