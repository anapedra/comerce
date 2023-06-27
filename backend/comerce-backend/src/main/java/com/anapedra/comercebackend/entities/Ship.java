package com.anapedra.comercebackend.entities;
/*
import org.apache.tomcat.jni.Address;

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
    private Double costShipSP;
    private Double costShiBR;
    private LocalDate expectedShipDate;
    private Double costShip;
    @ManyToOne
    @JoinColumn(name = "tableShipId")
    private TableShip tableShip;
    @OneToOne
    @MapsId
    private Order order;

    public Ship(Long id,Double costShipSP,Double costShiBR, LocalDate expectedShipDate, Double costShip,
                Order order,TableShip tableShip) {
        this.id = id;
        this.costShipSP = costShipSP;
        this.costShiBR = costShiBR;
        this.expectedShipDate = expectedShipDate;
        this.costShip = costShip;
        this.order = order;
        this.tableShip=tableShip;
    }

    public Ship() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TableShip getTableShip() {
        return tableShip;
    }

    public void setTableShip(TableShip tableShip) {
        this.tableShip = tableShip;
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

 */






