package com.anapedra.comercebackend.dtos;

/*

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ShipDTO implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private Double costShipSP;
    private Double costShiBR;
    private LocalDate expectedShipDate;
    private Double costShip;
    private Long orderId;

    public ShipDTO(Long id, Double costShipSP, Double costShiBR, LocalDate expectedShipDate, Double costShip, Long orderId, Long tableShipId) {
        this.id = id;
        this.costShipSP = costShipSP;
        this.costShiBR = costShiBR;
        this.expectedShipDate = expectedShipDate;
        this.costShip = costShip;
        this.orderId = orderId;
        this.tableShipId = tableShipId;
    }

    private Long tableShipId;



    public ShipDTO(){

    }

    public ShipDTO(Ship entity){
        id=entity.getId();
        costShipSP=entity.getCostShipSP();
        costShiBR=entity.getCostShiBR();
        expectedShipDate=entity.getExpectedShipDate();
        orderId=entity.getOrder().getId();
        tableShipId=entity.getTableShip().getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getTableShipId() {
        return tableShipId;
    }

    public void setTableShipId(Long tableShipId) {
        this.tableShipId = tableShipId;
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

 */




