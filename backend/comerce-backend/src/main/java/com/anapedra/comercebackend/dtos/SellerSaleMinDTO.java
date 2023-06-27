package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;

public class SellerSaleMinDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private int totalSeller;
    private double sumSale;


    public SellerSaleMinDTO() {

    }

    public SellerSaleMinDTO( int totalSeller, double sumSale) {
        this.totalSeller = totalSeller;
        this.sumSale = sumSale;
    }

    public SellerSaleMinDTO(Order entity) {
        totalSeller = Order.getTotalVendas();
        sumSale=entity.getReportSale().getSumSale();


    }


    public int getTotalSeller() {
        return totalSeller;
    }

    public void setTotalSeller(int totalSeller) {
        this.totalSeller = totalSeller;
    }

    public double getSumSale() {
        return sumSale;
    }

    public void setSumSale(double sumSale) {
        this.sumSale = sumSale;
    }
}
