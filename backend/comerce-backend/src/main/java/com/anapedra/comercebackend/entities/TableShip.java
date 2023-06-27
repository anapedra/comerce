package com.anapedra.comercebackend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_table_ship")
public class TableShip implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Double minAmountFreeShipSP;
    private  Double minAmountFreeShipBRAndOutsideSP;
    private  Double percentShipSP;
    private  Double percentShipBRAndOutsideSP;


    public TableShip(Long id, Double minAmountFreeShipSP, Double minAmountFreeShipBRAndOutsideSP, Double percentShipSP, Double percentShipBRAndOutsideSP) {
        this.id = id;
        this.minAmountFreeShipSP = minAmountFreeShipSP;
        this.minAmountFreeShipBRAndOutsideSP = minAmountFreeShipBRAndOutsideSP;
        this.percentShipSP = percentShipSP;
        this.percentShipBRAndOutsideSP = percentShipBRAndOutsideSP;
    }

    public TableShip() {

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

    public Double getPercentShipSP() {
        return percentShipSP;
    }

    public void setPercentShipSP(Double percentShipSP) {
        this.percentShipSP = percentShipSP;
    }

    public Double getPercentShipBRAndOutsideSP() {
        return percentShipBRAndOutsideSP;
    }

    public void setPercentShipBRAndOutsideSP(Double percentShipBRAndOutsideSP) {
        this.percentShipBRAndOutsideSP = percentShipBRAndOutsideSP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableShip)) return false;
        TableShip tableShip = (TableShip) o;
        return Objects.equals(id, tableShip.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
