package com.anapedra.comercebackend.entities;
/*
import com.anapedra.comercebackend.entities.enums.TypePhone;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_phone_list")
public class Phone implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private Integer typePhone;
    private String timeAvailability;
    @ManyToOne
    @JoinColumn(name = "additionalDataId")
    private AdditionalData additionalData;


    public Phone(Long id, String phoneNumber, TypePhone typePhone, String timeAvailability, AdditionalData additionalData) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        setTypePhone(typePhone);
        this.timeAvailability = timeAvailability;
        this.additionalData = additionalData;
    }

    public Phone() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public TypePhone getTypePhone(){
        return TypePhone.valueOf(typePhone);
    }

    public void setTypePhone(TypePhone typePhone) {
        if (typePhone != null){
            this.typePhone = typePhone.getCode();
        }
    }

    public String getTimeAvailability() {
        return timeAvailability;
    }

    public void setTimeAvailability(String timeAvailability) {
        this.timeAvailability = timeAvailability;
    }

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phoneList = (Phone) o;
        return Objects.equals(id, phoneList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

 */
