package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
public class Employee extends User implements Serializable {
    private static final long serialVersionUID=1L;

   private String descriptionFunction;
   private Double salary;
   @ManyToOne
   @JoinColumn(name = "shift_id")
   private Shift shift;
   @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   private LocalDate hiringDate;
   @OneToMany(mappedBy = "seller")
   private List<Order>orders=new ArrayList<>();
   @OneToMany(mappedBy = "employee")
   private List<Absence>absences=new ArrayList<>();
   @OneToMany(mappedBy = "employee")
   private List<ExtraHour>extraHours=new ArrayList<>();
  // private Demissaao demissaao;
 //  private Double commission; sera uma função
    @ManyToMany
    @JoinTable(name = "tb_employee_salesTarget",
            joinColumns = @JoinColumn(name = "employeeId"),
            inverseJoinColumns = @JoinColumn(name = "salesTargetId"))
   private Set<SalesTarget> salesTarget=new HashSet<>();//metas de vendas



    public Employee(Long id, String name, Instant momentRegistration, String mainPhone, String registrationEmail, String password,
                    AdditionalData additionalData, String descriptionFunction, Double salary, Shift shift,LocalDate hiringDate) {
        super(id, name, momentRegistration, mainPhone, registrationEmail, password, additionalData);
        this.descriptionFunction = descriptionFunction;
        this.salary = salary;
        this.shift = shift;
        this.hiringDate = hiringDate;

    }

    public Employee() {

    }

    public String getDescriptionFunction() {
        return descriptionFunction;
    }

    public void setDescriptionFunction(String descriptionFunction) {
        this.descriptionFunction = descriptionFunction;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Shift getShift() {
        return shift;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }
    @Override
    public List<Order> getOrders() {
        return orders;
    }
    public List<Absence> getAbsences() {
        return absences;
    }
    public List<ExtraHour> getExtraHours() {
        return extraHours;
    }
    public Set<SalesTarget> getSalesTarget() {
        return salesTarget;
    }



}


