package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;
import java.util.List;

public class CalcSaleDTO implements Serializable {
    private static final long serialVersionUID=1L;


    private Long id;
    private String nameSeller;
    private String cpfSeller;
    private Double totalSale;
    private Double averageSales;

    public CalcSaleDTO(Long id, String nameSeller, String cpfSeller, Double totalSale, Double averageSales) {
        this.id = id;
        this.nameSeller = nameSeller;
        this.cpfSeller = cpfSeller;
        this.totalSale = totalSale;
        this.averageSales = averageSales;
    }

    public CalcSaleDTO(){

    }

    public CalcSaleDTO(Order entity){
     id=entity.getSeller().getId();
   //  totalSale= Order.getTotalVendas();
     nameSeller=entity.getSeller().getName();
     nameSeller=entity.getSeller().getCpf();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String nameSeller) {
        this.nameSeller = nameSeller;
    }

    public String getCpfSeller() {
        return cpfSeller;
    }

    public void setCpfSeller(String cpfSeller) {
        this.cpfSeller = cpfSeller;
    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public Double getAverageSales() {
        return averageSales;
    }

    public void setAverageSales(Double averageSales) {
        this.averageSales = averageSales;
    }
}


