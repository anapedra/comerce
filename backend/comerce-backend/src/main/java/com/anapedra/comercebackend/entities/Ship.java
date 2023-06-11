package com.anapedra.comercebackend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_ship")
public class Ship implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Double minAmountFreeShipSP;
    private  Double minAmountFreeShipBRAndOutsideSP;
    private Double costShipSP;
    private Double costShiBR;
    private LocalDate expectedShipDate;
    private Double costShip;
    @OneToOne
    @MapsId
    private Order order;
    @ManyToOne
    @JoinColumn(name = "addressShipId")
    private Address addressShip;

    public Ship(Long id, Double minAmountFreeShipSP, Double minAmountFreeShipBRAndOutsideSP, Double costShipSP,
                Double costShiBR, LocalDate expectedShipDate, Double costShip, Order order, Address addressShip) {
        this.id = id;
        this.minAmountFreeShipSP = minAmountFreeShipSP;
        this.minAmountFreeShipBRAndOutsideSP = minAmountFreeShipBRAndOutsideSP;
        this.costShipSP = costShipSP;
        this.costShiBR = costShiBR;
        this.expectedShipDate = expectedShipDate;
        this.costShip = costShip;
        this.order = order;
        this.addressShip = addressShip;
    }



    public Ship() {

    }

    public Double getCalcShip(){

            if (addressShip.getState().equalsIgnoreCase("SP") && order.getTotal() < minAmountFreeShipSP){
                setCostShip(costShipSP);
            }
            else if (!addressShip.getState().equalsIgnoreCase("SP") && order.
                    getTotal()< minAmountFreeShipBRAndOutsideSP && addressShip.getCity().equalsIgnoreCase("BR")){
                setCostShip(costShiBR);
            }
            else {
                setCostShip(0.0);
            }
            return getCostShip();


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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Address getAddressShip() {
        return addressShip;
    }

    public void setAddressShip(Address addressShip) {
        this.addressShip = addressShip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ship)) return false;
        Ship ship = (Ship) o;
        return Objects.equals(id, ship.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
