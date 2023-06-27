package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.services.CalcSale;

import java.io.Serializable;

public class SumSalerDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Double sumSale;

    public SumSalerDTO() {

    }

    public Double getSumSale() {
        return sumSale;
    }

    public void setSumSale(Double sumSale) {
        this.sumSale = sumSale;
    }

    public SumSalerDTO(CalcSale calcSale) {
     sumSale= calcSale.getCalcSale();
    }




}
