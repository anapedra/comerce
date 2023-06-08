package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.pk.EmployeeExtraHourPK;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_employee_extra_hour")
public class EmployeeExtraHour implements Serializable {
    private static final long serialVersionUID=1L;

    @EmbeddedId
    EmployeeExtraHourPK id=new EmployeeExtraHourPK();
    private LocalDate dateExtraHour;
    private Double startExtraTimeDay;
    private Double endExtraTimeDay;


    public EmployeeExtraHour(Employee employee,ExtraHour extraHour,LocalDate dateExtraHour,
                             Double startExtraTimeDay, Double endExtraTimeDay) {
        this.dateExtraHour = dateExtraHour;
        this.startExtraTimeDay = startExtraTimeDay;
        this.endExtraTimeDay = endExtraTimeDay;
        id.setEmployee(employee);
        id.setExtraHour(extraHour);
    }

    public EmployeeExtraHour() {

    }

    public ExtraHour getExtraHour(){
        return id.getExtraHour();
    }
    public void setExtraHour(ExtraHour extraHour){
        id.setExtraHour(extraHour);
    }
    public Employee getEmployee(){
        return id.getEmployee();
    }
    public void setEmployee(Employee employee){
        id.setEmployee(employee);
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

    public Double getQuantityExtraTimeDay(){
        return endExtraTimeDay-startExtraTimeDay;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeExtraHour)) return false;
        EmployeeExtraHour that = (EmployeeExtraHour) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
