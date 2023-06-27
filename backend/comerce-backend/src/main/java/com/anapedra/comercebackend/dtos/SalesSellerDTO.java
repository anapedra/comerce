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
    private Long idOrder;
    private String sellerName;
    private String clientName;
    private LocalDate dateOrder;
    private Double total;




    public SalesSellerDTO () {

    }

    public SalesSellerDTO(Long idOrder, String sellerName, String clientName, LocalDate dateOrder, Double total) {
        this.idOrder = idOrder;
        this.sellerName = sellerName;
        this.clientName = clientName;
        this.dateOrder = dateOrder;
        this.total = total;
    }

    public SalesSellerDTO (Order entity) {
        idOrder=entity.getId();
        sellerName=entity.getSeller().getName();
        clientName=entity.getClient().getName();
        total=entity.getTotal();
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getClientName() {
        return clientName;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public Double getTotal() {
        return total;
    }
}
