package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Absence;
import com.anapedra.comercebackend.entities.enums.TypeAbsence;

import java.time.LocalDate;
import java.util.Objects;

public class AbsenceDTO {

    private Long id;
    private LocalDate dateAbsence;
    private String description;
    private String selleName;
    private TypeAbsence typeAbsence;

    public AbsenceDTO() {

    }

    public AbsenceDTO(Long id, LocalDate dateAbsence, String description, String selleName, TypeAbsence typeAbsence) {
        this.id = id;
        this.dateAbsence = dateAbsence;
        this.description = description;
        this.selleName = selleName;
        this.typeAbsence = typeAbsence;
    }

    public AbsenceDTO(Absence entity){
        id= entity.getId();
        dateAbsence=entity.getDateAbsence();
        description= entity.getDescription();
        selleName=entity.getEmployee().getName();
        typeAbsence=entity.geTypeAbsence();
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

    public String getSelleName() {
        return selleName;
    }

    public void setSelleName(String selleName) {
        this.selleName = selleName;
    }

    public TypeAbsence getTypeAbsence() {
        return typeAbsence;
    }

    public void setTypeAbsence(TypeAbsence typeAbsence) {
        this.typeAbsence = typeAbsence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbsenceDTO)) return false;
        AbsenceDTO that = (AbsenceDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
