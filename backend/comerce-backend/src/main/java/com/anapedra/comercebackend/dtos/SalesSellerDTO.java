package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.OrderItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SalesSellerDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String sellerName;
    private LocalDate dateOrder;
    private Double total;
    private Integer quantityProduct;
    private List<OrderItemDTO> items=new ArrayList<>();


    public SalesSellerDTO () {

    }

    public SalesSellerDTO(Long id, String sellerName, LocalDate dateOrder, Double total, Integer quantityProduct) {
        this.id = id;
        this.sellerName = sellerName;
        this.dateOrder = dateOrder;
        this.total = total;
        this.quantityProduct = quantityProduct;
    }

    public SalesSellerDTO (Order entity) {
        id= entity.getId();
        sellerName=entity.getSeller().getName();
        quantityProduct=entity.getQuantityProduct();
        total=entity.getTotal();
    }

    public SalesSellerDTO (Order entity, Set<OrderItem> orderItems){
        this(entity);
        entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
