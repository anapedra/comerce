package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.SalesTargetStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import static com.anapedra.comercebackend.entities.enums.TypeAbsence.UNJUSTIFIED;

@Entity
@Table(name = "tb_employee")
public class Employee extends User implements Serializable {
    private static final long serialVersionUID=1L;


   private Double salary;
   private final Double SIMPLE_COMMISSION_PERCENTAGE=0.02; // Verificar se uma constante nesse casso é o mais interessante!
    private final Double SUPER_COMMISSION_PERCENTAGE=0.03;

   @ManyToOne
   @JoinColumn(name = "departmentId")
   private Department department;

   @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
   private LocalDate hiringDate;

   @ManyToOne
   @JoinColumn(name = "salesTargetId")
   private SalesTarget salesTarget;

   @OneToMany(mappedBy = "seller")
   private List<Order>orders=new ArrayList<>();

   @OneToMany(mappedBy = "employee")
   private List<Absence>absences=new ArrayList<>();

    @OneToMany(mappedBy = "id.employee")
    private Set<EmployeeExtraHour> extraHours =new HashSet<>();

    public Employee(Long id, String name, Instant momentRegistration, String mainPhone, String cpf, String registrationEmail, String password, AdditionalData additionalData, Double salary,
                    Department department, LocalDate hiringDate, SalesTarget salesTarget) {
        super(id, name, momentRegistration, mainPhone, cpf, registrationEmail, password, additionalData);
        this.salary = salary;
        this.department = department;
        this.hiringDate = hiringDate;
        this.salesTarget = salesTarget;
    }

    public Employee() {

    }



    public double getCommission(){
        double sumOrder = 0.0;
        double commission =0.0;
        for (Order order : orders) {
            sumOrder += order.getTotal();
        }
        if (sumOrder >  salesTarget.getValueSalesTargetStatus() && sumOrder < salesTarget.getValueSalesTargetStatus()*4){
            commission = sumOrder * SIMPLE_COMMISSION_PERCENTAGE;
            salesTarget.setSalesTargetStatus(SalesTargetStatus.SALES_TARGET);

        }
        else if (sumOrder >  salesTarget.getValueSalesTargetStatus()*2){
            commission = sumOrder * SUPER_COMMISSION_PERCENTAGE;
            salesTarget.setSalesTargetStatus(SalesTargetStatus.SUPER_SALES_TARGET);
        }
        else {
            commission=0.0;
        }
        return commission;
    }
    public double getDiscountAbsences(){
        return  (salary/30)*absences.size();

    }


    public double getTotalRemuneration(){
       return (getCommission()+salary)-getDiscountAbsences();
    }



    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        this.hiringDate = hiringDate;
    }

    public void setSalesTarget(SalesTarget salesTarget) {
        this.salesTarget = salesTarget;
    }
    public SalesTarget getSalesTarget() {
        return salesTarget;
    }

    public Double getSIMPLE_COMMISSION_PERCENTAGE() {
        return SIMPLE_COMMISSION_PERCENTAGE;
    }

    public Double getSUPER_COMMISSION_PERCENTAGE() {
        return SUPER_COMMISSION_PERCENTAGE;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<EmployeeExtraHour> getExtraHours() {
        return extraHours;
    }
    public List<ExtraHour> getExtraHour(){
        return extraHours.stream().map(x->x.getExtraHour()).toList();
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
    public List<Absence> getAbsences() {
        return absences;
    }



}


