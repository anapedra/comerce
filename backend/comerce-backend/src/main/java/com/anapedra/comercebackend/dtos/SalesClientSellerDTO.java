package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;
import java.time.LocalDate;

public class SalesClientSellerDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long orderId;
    private String sellerName;
    private String clientName;
    private LocalDate dateOrder;
    private Double total;


    public SalesClientSellerDTO() {

    }

    public SalesClientSellerDTO(Order entity) {
      orderId= entity.getId();
      sellerName=entity.getSeller().getName();
      clientName=entity.getClient().getName();
      dateOrder=entity.getDateOrder();
      total=entity.getTotal();

    }


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
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
}
