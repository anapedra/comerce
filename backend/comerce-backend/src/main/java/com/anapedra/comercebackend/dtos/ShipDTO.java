package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Order;
import com.anapedra.comercebackend.entities.Ship;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ShipDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private  Double minAmountFreeShipSP;
    private  Double minAmountFreeShipBRAndOutsideSP;
    private Double costShipSP;
    private Double costShiBR;
    private LocalDate expectedShipDate;
    private Double costShip;
    private Long orderId;

    public ShipDTO(Long id, Double minAmountFreeShipSP, Double minAmountFreeShipBRAndOutsideSP, Double costShipSP,
                   Double costShiBR, LocalDate expectedShipDate, Double costShip, Long order) {
        this.id = id;
        this.minAmountFreeShipSP = minAmountFreeShipSP;
        this.minAmountFreeShipBRAndOutsideSP = minAmountFreeShipBRAndOutsideSP;
        this.costShipSP = costShipSP;
        this.costShiBR = costShiBR;
        this.expectedShipDate = expectedShipDate;
        this.costShip = costShip;
        this.orderId = orderId;
    }
    public ShipDTO(){

    }

    public ShipDTO(Ship entity){
        id=entity.getId();
        minAmountFreeShipSP=entity.getMinAmountFreeShipSP();
        minAmountFreeShipBRAndOutsideSP=entity.getMinAmountFreeShipBRAndOutsideSP();
        costShipSP=entity.getCostShipSP();
        costShiBR=entity.getCostShiBR();
        expectedShipDate=entity.getExpectedShipDate();
        orderId=entity.getOrder().getId();
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

    public Double getCostShipSP() {
        return costShipSP;
    }

    public void setCostShipSP(Double costShipSP) {
        this.costShipSP = costShipSP;
    }

    public Double getCostShiBR() {
        return costShiBR;
    }

    public void setCostShiBR(Double costShiBR) {
        this.costShiBR = costShiBR;
    }

    public LocalDate getExpectedShipDate() {
        return expectedShipDate;
    }

    public void setExpectedShipDate(LocalDate expectedShipDate) {
        this.expectedShipDate = expectedShipDate;
    }

    public Double getCostShip() {
        return costShip;
    }

    public void setCostShip(Double costShip) {
        this.costShip = costShip;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShipDTO)) return false;
        ShipDTO shipDTO = (ShipDTO) o;
        return Objects.equals(id, shipDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
