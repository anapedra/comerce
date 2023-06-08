package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.EmployeeExtraHour;
import com.anapedra.comercebackend.entities.ExtraHour;
import com.anapedra.comercebackend.entities.enums.ExtraHourStatus;

import java.io.Serializable;
import java.time.LocalDate;

public class ExtraHourDTO  implements Serializable {
    private static final long serialVersionUID=1L;

    private Long id;
    private String descriptionExtraHoursByDay;
    private Double quantityExtraHoursByDay;
    private LocalDate dateExtraHours;
    private boolean nightOvertime;
    private String selleName;;
     private ExtraHourStatus status;


    public ExtraHourDTO(){

    }
    public ExtraHourDTO( String descriptionExtraHoursByDay, Double quantityExtraHoursByDay, LocalDate dateExtraHours,
                        boolean nightOvertime,String selleName,ExtraHourStatus status) {
        this.descriptionExtraHoursByDay = descriptionExtraHoursByDay;
        this.quantityExtraHoursByDay = quantityExtraHoursByDay;
        this.dateExtraHours = dateExtraHours;
        this.nightOvertime = nightOvertime;
        this.selleName=selleName;
        this.status=status;
    }

    public ExtraHourDTO(ExtraHour entity){
        descriptionExtraHoursByDay= entity.getDescriptionExtraHoursByDay();
        status= entity.getExtraHourStatus();
        quantityExtraHoursByDay=entity.getQuantityExtraHoursByDay();// depois fazer uma pk
        dateExtraHours=entity.getDateExtraHours();
        nightOvertime=entity.isNightOvertime();
        selleName=entity.getEmployee().getName();
        status=entity.getExtraHourStatus();
    }

    public ExtraHourDTO(EmployeeExtraHour extraHour) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriptionExtraHoursByDay() {
        return descriptionExtraHoursByDay;
    }

    public void setDescriptionExtraHoursByDay(String descriptionExtraHoursByDay) {
        this.descriptionExtraHoursByDay = descriptionExtraHoursByDay;
    }

    public Double getQuantityExtraHoursByDay() {
        return quantityExtraHoursByDay;
    }

    public void setQuantityExtraHoursByDay(Double quantityExtraHoursByDay) {
        this.quantityExtraHoursByDay = quantityExtraHoursByDay;
    }

    public LocalDate getDateExtraHours() {
        return dateExtraHours;
    }

    public void setDateExtraHours(LocalDate dateExtraHours) {
        this.dateExtraHours = dateExtraHours;
    }

    public boolean isNightOvertime() {
        return nightOvertime;
    }

    public void setNightOvertime(boolean nightOvertime) {
        this.nightOvertime = nightOvertime;
    }

    public String getSelleName() {
        return selleName;
    }

    public void setSelleName(String selleName) {
        this.selleName = selleName;
    }

    public ExtraHourStatus getStatus() {
        return status;
    }

    public void setStatus(ExtraHourStatus status) {
        this.status = status;
    }


}
