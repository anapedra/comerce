package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.OrderItem;
import com.anapedra.comercebackend.entities.ReportSale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportSaleDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String description;
    private Double sumSale;
    private List<OrderDTO> orders=new ArrayList<>();

    public ReportSaleDTO() {

    }

    public ReportSaleDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ReportSaleDTO(ReportSale entity) {
      id= entity.getId();
      description= entity.getDescription();
      sumSale= entity.getSumSale();
    }
    public ReportSaleDTO(ReportSale entity, List<Order> orders){
        this(entity);
        entity.getOrders().forEach(order -> this.orders.add(new OrderDTO(order)));
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSumSale() {
        return sumSale;
    }

    public void setSumSale(Double sumSale) {
        this.sumSale = sumSale;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }


}
