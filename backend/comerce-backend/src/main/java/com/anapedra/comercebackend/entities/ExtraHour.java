package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.ExtraHourStatus;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_employee")
public class ExtraHour  implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final Double PERCENTAGE_DAYTIME_OVERTIME=0.5;
    private final Double PERCENTAGE_NIGHT_OVERTIME_OR_SUNDAY_HOLIDAYS=1.0;
    private Integer extraHourStatus;
    private String descriptionExtraHoursByDay;
    private Double quantityExtraHoursByDay;
    private LocalDate dateExtraHours;
    private boolean nightOvertime;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToMany(mappedBy = "id.extraHour")
    private Set<EmployeeExtraHour> extraHours =new HashSet<>();

    public ExtraHour(Long id,ExtraHourStatus extraHourStatus, String descriptionExtraHoursByDay, Double quantityExtraHoursByDay,
                     LocalDate dateExtraHours, boolean nightOvertime, Employee employee) {
        this.id = id;
        setExtraHourStatus(extraHourStatus);
        this.descriptionExtraHoursByDay = descriptionExtraHoursByDay;
        this.quantityExtraHoursByDay = quantityExtraHoursByDay;
        this.dateExtraHours = dateExtraHours;
        this.nightOvertime = nightOvertime;
        this.employee = employee;
    }

    public ExtraHour() {

    }

    public double getTotalExtraHour(){
        double soma = 0.0;
        for (EmployeeExtraHour extraHour : extraHours) {
           soma += extraHour.getEndExtraTimeDay() ;
        }
        return soma;
    }


    public ExtraHourStatus getExtraHourStatus() {
        return ExtraHourStatus.valueOf(extraHourStatus);
    }

    public void setExtraHourStatus(ExtraHourStatus extraHourStatus) {
        if (extraHourStatus != null){
            this.extraHourStatus = extraHourStatus.getCode();
        }
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

    public Set<EmployeeExtraHour> getExtraHours() {
        return extraHours;
    }

    public List<Employee> getProducts(){
        return extraHours.stream().map(x->x.getEmployee()).toList();
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
