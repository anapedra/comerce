package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_employee")
public class ExtraHour  implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descriptionExtraHoursByDay;
    private Double quantityExtraHoursByDay;
    private LocalDate dateExtraHours;
    private boolean nightOvertime;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    //calculos de horas extras(metodos)

    public ExtraHour(Long id, String descriptionExtraHoursByDay, Double quantityExtraHoursByDay,
                     LocalDate dateExtraHours, boolean nightOvertime, Employee employee) {
        this.id = id;
        this.descriptionExtraHoursByDay = descriptionExtraHoursByDay;
        this.quantityExtraHoursByDay = quantityExtraHoursByDay;
        this.dateExtraHours = dateExtraHours;
        this.nightOvertime = nightOvertime;
        this.employee = employee;
    }

    public ExtraHour() {

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExtraHour)) return false;
        ExtraHour extraHour = (ExtraHour) o;
        return Objects.equals(id, extraHour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
