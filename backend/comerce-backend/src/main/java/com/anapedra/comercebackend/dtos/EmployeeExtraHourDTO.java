package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.EmployeeExtraHour;
import com.anapedra.comercebackend.entities.pk.OrderItemPK;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeExtraHourDTO  implements Serializable {
    private static final long serialVersionUID=1L;
    private OrderItemPK id=new OrderItemPK();
    private LocalDate dateExtraHour;
    private Double startExtraTimeDay;
    private Double endExtraTimeDay;
    private Double totalExtraTimeDay;
    private String selleName;

    public EmployeeExtraHourDTO() {

    }

    public EmployeeExtraHourDTO(LocalDate dateExtraHour, Double startExtraTimeDay,
                                Double endExtraTimeDay, Double totalExtraTimeDay, String selleName) {
        this.dateExtraHour = dateExtraHour;
        this.startExtraTimeDay = startExtraTimeDay;
        this.endExtraTimeDay = endExtraTimeDay;
        this.totalExtraTimeDay = totalExtraTimeDay;
        this.selleName = selleName;
    }

    public EmployeeExtraHourDTO(EmployeeExtraHour entity) {
        dateExtraHour=entity.getDateExtraHour();
        startExtraTimeDay=entity.getStartExtraTimeDay();
        endExtraTimeDay=entity.getEndExtraTimeDay();
        selleName=entity.getEmployee().getName();
        totalExtraTimeDay=entity.getQuantityExtraTimeDay();

    }

    public LocalDate getDateExtraHour() {
        return dateExtraHour;
    }

    public void setDateExtraHour(LocalDate dateExtraHour) {
        this.dateExtraHour = dateExtraHour;
    }

    public Double getStartExtraTimeDay() {
        return startExtraTimeDay;
    }

    public void setStartExtraTimeDay(Double startExtraTimeDay) {
        this.startExtraTimeDay = startExtraTimeDay;
    }

    public Double getEndExtraTimeDay() {
        return endExtraTimeDay;
    }

    public void setEndExtraTimeDay(Double endExtraTimeDay) {
        this.endExtraTimeDay = endExtraTimeDay;
    }

    public Double getTotalExtraTimeDay() {
        return totalExtraTimeDay;
    }

    public void setTotalExtraTimeDay(Double totalExtraTimeDay) {
        this.totalExtraTimeDay = totalExtraTimeDay;
    }

    public String getSelleName() {
        return selleName;
    }

    public void setSelleName(String selleName) {
        this.selleName = selleName;
    }
}
