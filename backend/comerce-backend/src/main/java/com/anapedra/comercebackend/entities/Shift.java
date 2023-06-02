package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_shift")
public class Shift implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String shiftStartTime;
    private String shiftEndTime;
    @OneToMany(mappedBy = "shift")
    private List<Employee>employees=new ArrayList<>();

    public Shift(Long id, String description, String shiftStartTime, String shiftEndTime) {
        this.id = id;
        this.description = description;
        this.shiftStartTime = shiftStartTime;
        this.shiftEndTime = shiftEndTime;
    }
    public Shift() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShiftStartTime() {
        return shiftStartTime;
    }

    public void setShiftStartTime(String shiftStartTime) {
        this.shiftStartTime = shiftStartTime;
    }

    public String getShiftEndTime() {
        return shiftEndTime;
    }

    public void setShiftEndTime(String shiftEndTime) {
        this.shiftEndTime = shiftEndTime;
    }

    public List<Employee> getEmployees() {
        return employees;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shift)) return false;
        Shift shift = (Shift) o;
        return Objects.equals(id, shift.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
