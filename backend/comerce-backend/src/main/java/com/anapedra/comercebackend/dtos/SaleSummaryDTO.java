package com.anapedra.comercebackend.dtos;


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

    public SaleSummaryDTO(OrderDTO entity) {
        sellerName= entity.getSelleName();
        total=entity.getTotal();
    }



    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}


