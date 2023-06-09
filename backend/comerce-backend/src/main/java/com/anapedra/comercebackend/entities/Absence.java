package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.OrderStatus;
import com.anapedra.comercebackend.entities.enums.TypeAbsence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_absence")
public class Absence implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateAbsence;
    private String description;
    private Integer absence;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Absence(Long id, LocalDate dateAbsence, String description, TypeAbsence absence, Employee employee){
        this.id = id;
        this.dateAbsence = dateAbsence;
        this.description = description;
        setTypeAbsence(absence);
        this.employee = employee;
    }

    public Absence() {

    }

    public TypeAbsence geTypeAbsence() {
        return TypeAbsence.valueOf(absence);
    }

    public void setTypeAbsence(TypeAbsence typeAbsence) {
        if (absence != null){
            this.absence = typeAbsence.getCode();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(LocalDate dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof Absence)) return false;
        Absence absence = (Absence) o;
        return Objects.equals(id, absence.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
