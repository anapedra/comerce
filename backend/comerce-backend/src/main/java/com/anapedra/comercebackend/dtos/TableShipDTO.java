package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.TableShip;

import java.io.Serializable;

public class TableShipDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private  Double minAmountFreeShipSP;
    private  Double minAmountFreeShipBRAndOutsideSP;

    public TableShipDTO() {

    }
    public TableShipDTO(Long id, Double minAmountFreeShipSP, Double minAmountFreeShipBRAndOutsideSP) {
        this.id = id;
        this.minAmountFreeShipSP = minAmountFreeShipSP;
        this.minAmountFreeShipBRAndOutsideSP = minAmountFreeShipBRAndOutsideSP;
    }

    public TableShipDTO(TableShip entity){
        id=entity.getId();
        minAmountFreeShipBRAndOutsideSP=entity.getMinAmountFreeShipBRAndOutsideSP();
        minAmountFreeShipSP=entity.getMinAmountFreeShipSP();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinAmountFreeShipSP() {
        return minAmountFreeShipSP;
    }

    public void setMinAmountFreeShipSP(Double minAmountFreeShipSP) {
        this.minAmountFreeShipSP = minAmountFreeShipSP;
    }

    public Double getMinAmountFreeShipBRAndOutsideSP() {
        return minAmountFreeShipBRAndOutsideSP;
    }

    public void setMinAmountFreeShipBRAndOutsideSP(Double minAmountFreeShipBRAndOutsideSP) {
        this.minAmountFreeShipBRAndOutsideSP = minAmountFreeShipBRAndOutsideSP;
    }
}
