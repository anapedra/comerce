package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeAbsence;
import jakarta.persistence.*;
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
    private Integer typeAbsence;
    private String description;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Absence(Long id, LocalDate dateAbsence, TypeAbsence typeAbsence, String description, Employee employee) {
        this.id = id;
        this.dateAbsence = dateAbsence;
        setTypeAbsence(typeAbsence);
        this.description = description;
        this.employee = employee;
    }

    public Absence() {

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
    public TypeAbsence getTypeAbsence() {
        return TypeAbsence.valueOf(typeAbsence);
    }

    public void setTypeAbsence(TypeAbsence typeAbsence) {
        if (typeAbsence != null){
            this.typeAbsence = typeAbsence.getCode();
        }
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
