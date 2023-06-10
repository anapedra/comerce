package com.anapedra.comercebackend.entities;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_departament")
public class Department implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @Column(columnDefinition = "TEXT")
    private String description;

    private Instant momentRegistration;

    private Instant momentUpdate;
    private String descriptionFunction;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees=new ArrayList<>();

    public  Department(Long id, Shift shift, String description,
                       Instant momentRegistration, Instant momentUpdate,
                       String descriptionFunction) {
        this.id = id;
        this.shift = shift;
        this.description = description;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.descriptionFunction = descriptionFunction;

    }

    public  Department() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getMomentRegistration() {
        return momentRegistration;
    }

    public void setMomentRegistration(Instant momentRegistration) {
        this.momentRegistration = momentRegistration;
    }

    public Instant getMomentUpdate() {
        return momentUpdate;
    }

    public void setMomentUpdate(Instant momentUpdate) {
        this.momentUpdate = momentUpdate;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
