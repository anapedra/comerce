package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.*;
import com.anapedra.comercebackend.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private LocalDate dateOrder;
    private OrderStatus status;
    private String selleName;
    private String clientName;
    private Double total;
    private Integer quantityProduct;
    private List<OrderItemDTO> items=new ArrayList<>();

    public OrderDTO() {

    }

    public OrderDTO(Long id, Instant momentRegistration,
                    LocalDate dateOrder, OrderStatus status, String selleName, String clientName, Double total,Integer quantityProduct) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.dateOrder = dateOrder;
        this.status = status;
        this.selleName = selleName;
        this.clientName = clientName;
        this.total = total;
        this.quantityProduct=quantityProduct;
    }

    public OrderDTO(Order entity) {
        id=entity.getId();
        momentRegistration=entity.getMomentRegistration();
        momentRegistration=entity.getMomentRegistration();
        dateOrder=entity.getDateOrder();
        status=entity.getStatus();
        selleName=entity.getSeller().getName();
        clientName = entity.getClient().getName();
        quantityProduct=entity.getQuantityProduct();
        total= entity.getTotal();
        //fazer metódo de total produto
        //entity.getPayment().getTypeFormPayment();
    }

    public OrderDTO(Order entity,Set<OrderItem> orderItems){
        this(entity);
        entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentRegistration() {
        return momentRegistration;
    }

    public void setMomentRegistration(Instant momentRegistration) {
        this.momentRegistration = momentRegistration;
    }

    public Instant getMomentUpdate() {
        return momentUpdate;
    }

    public void setMomentUpdate(Instant momentUpdate) {
        this.momentUpdate = momentUpdate;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getSelleName() {
        return selleName;
    }

    public void setSelleName(String selleName) {
        this.selleName = selleName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(getId(), orderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
