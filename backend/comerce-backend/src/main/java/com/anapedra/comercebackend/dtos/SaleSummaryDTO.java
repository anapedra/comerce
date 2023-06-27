package com.anapedra.comercebackend.dtos;


import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;

public class SaleSummaryDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private String sellerName;
    private double total;

    public SaleSummaryDTO(String sellerName, double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO() {

    }

    public SaleSummaryDTO(Order entity) {
        sellerName= entity.getSeller().getName();
        total=entity.getTotal();
    }

    public String getSellerName() {
        return sellerName;
    }
    public double getTotal() {
        return total;
    }


}


