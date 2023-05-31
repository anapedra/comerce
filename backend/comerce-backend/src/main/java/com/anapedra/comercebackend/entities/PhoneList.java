package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeAddress;
import com.anapedra.comercebackend.entities.enums.TypePhone;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_phone_list")
public class PhoneList implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    private Integer typePhone;
    private String timeAvailability;
    @OneToOne
    @MapsId
    private AdditionalData additionalData;


    public PhoneList(Long id, String phoneNumber, TypePhone typePhone, String timeAvailability, AdditionalData additionalData) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        setTypePhone(typePhone);
        this.timeAvailability = timeAvailability;
        this.additionalData = additionalData;
    }

    public PhoneList() {

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
        if (!(o instanceof PhoneList)) return false;
        PhoneList phoneList = (PhoneList) o;
        return Objects.equals(id, phoneList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
