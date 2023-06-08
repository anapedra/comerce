package com.anapedra.comercebackend.entities.pk;

import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.ExtraHour;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeExtraHourPK implements Serializable {
    private static final long serialVersionUID=1L;

    @ManyToOne
    @JoinColumn(name = "extraHour_id")
    private ExtraHour extraHour;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public EmployeeExtraHourPK() {
    }

    public ExtraHour getExtraHour() {
        return extraHour;
    }

    public void setExtraHour(ExtraHour extraHour) {
        this.extraHour = extraHour;
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
        if (!(o instanceof EmployeeExtraHourPK)) return false;
        EmployeeExtraHourPK that = (EmployeeExtraHourPK) o;
        return Objects.equals(extraHour, that.extraHour) && Objects.equals(employee, that.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(extraHour, employee);
    }
}
