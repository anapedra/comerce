package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.SalesTargetStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "tb_sales_target")
public class SalesTarget implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer salesTargetStatus;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double valueSalesTargetStatus;
    @OneToMany(mappedBy = "salesTarget")
    private List<Employee> seller =new ArrayList<>();

    public SalesTarget(Long id,SalesTargetStatus salesTargetStatus ,LocalDate startDate, LocalDate endDate, Double valueSalesTargetStatus) {
        this.id = id;
        setSalesTargetStatus(salesTargetStatus);
        this.startDate = startDate;
        this.endDate = endDate;
        setSalesTargetStatus(salesTargetStatus);
    }

    public SalesTarget() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SalesTargetStatus getSalesTargetStatus() {
        return SalesTargetStatus.valueOf(salesTargetStatus);
    }

    public void setSalesTargetStatus(SalesTargetStatus salesTargetStatus) {
        if (salesTargetStatus != null){
            this.salesTargetStatus = salesTargetStatus.getCode();
        }
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getValueSalesTargetStatus() {
        return valueSalesTargetStatus;
    }

    public void setValueSalesTargetStatus(Double valueSalesTargetStatus) {
        this.valueSalesTargetStatus = valueSalesTargetStatus;
    }

    public List<Employee> getSeller() {
        return seller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesTarget)) return false;
        SalesTarget that = (SalesTarget) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
