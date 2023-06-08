package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Absence;
import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.SalesTarget;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeSelleDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String name;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private String mainPhone;
    private String cpf;
    private String registrationEmail;
    private Double salary;
    private LocalDate hiringDate;
    private SalesTarget salesTarget;
    private AdditionalDataDTO additionalData;
    private String departmentDescription;
    private Double discountAbsences;
    private Double totalCommission;
    private Double totalRemuneration;
    private List<AbsenceDTO>absences=new ArrayList<>();
    private List<ExtraHourDTO>extraHours=new ArrayList<>();

    public EmployeeSelleDTO() {

    }

    public EmployeeSelleDTO(Long id, String name, Instant momentRegistration, Instant momentUpdate, String mainPhone,String cpf,String registrationEmail,
                            Double salary, LocalDate hiringDate, SalesTarget salesTarget, AdditionalDataDTO additionalData,
                            String departmentDescription, Double discountAbsences, Double totalCommission, Double totalRemuneration) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.cpf=cpf;
        this.registrationEmail = registrationEmail;
        this.salary = salary;
        this.hiringDate = hiringDate;
        this.salesTarget = salesTarget;
        this.additionalData = additionalData;
        this.departmentDescription = departmentDescription;
        this.discountAbsences = discountAbsences;
        this.totalCommission = totalCommission;
        this.totalRemuneration = totalRemuneration;
    }

    public EmployeeSelleDTO(Employee entity){
        id = entity.getId();
        name = entity.getName();
        momentRegistration = entity.getMomentRegistration();
        momentUpdate = entity.getMomentUpdate();
        mainPhone = entity.getMainPhone();
        cpf=entity.getCpf();
        registrationEmail = entity.getRegistrationEmail();
        salary = entity.getSalary();
        discountAbsences= entity.getDiscountAbsences();
        totalCommission = entity.getCommission();
        totalRemuneration = entity.getTotalRemuneration();
        departmentDescription = entity.getDepartment().getDescription();
        additionalData = new AdditionalDataDTO(
                entity.getAdditionalData().getId(),
                entity.getAdditionalData().getAddresses(),
                entity.getAdditionalData().getEmails(),
                entity.getAdditionalData().getPhones());

    }
    public EmployeeSelleDTO(Employee entity, List<Absence>absences, List<ExtraHourDTO>extraHours) {
        this(entity);
        entity.getAbsences().forEach(absence -> this.absences.add(new AbsenceDTO(absence)));
        entity.getExtraHours().forEach(extraHour -> this.extraHours.add(new ExtraHourDTO(extraHour)));

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRegistrationEmail() {
        return registrationEmail;
    }

    public void setRegistrationEmail(String registrationEmail) {
        this.registrationEmail = registrationEmail;
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

    public SalesTarget getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(SalesTarget salesTarget) {
        this.salesTarget = salesTarget;
    }

    public AdditionalDataDTO getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalDataDTO additionalData) {
        this.additionalData = additionalData;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public Double getDiscountAbsences() {
        return discountAbsences;
    }

    public void setDiscountAbsences(Double discountAbsences) {
        this.discountAbsences = discountAbsences;
    }

    public Double getTotalCommission() {
        return totalCommission;
    }

    public void setTotalCommission(Double totalCommission) {
        this.totalCommission = totalCommission;
    }

    public Double getTotalRemuneration() {
        return totalRemuneration;
    }

    public void setTotalRemuneration(Double totalRemuneration) {
        this.totalRemuneration = totalRemuneration;
    }


    public List<AbsenceDTO> getAbsences() {
        return absences;
    }

    public List<ExtraHourDTO> getExtraHours() {
        return extraHours;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeSelleDTO)) return false;
        EmployeeSelleDTO that = (EmployeeSelleDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
