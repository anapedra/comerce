package com.anapedra.comercebackend.dtos;
/*
import com.anapedra.comercebackend.entities.Phone;
import com.anapedra.comercebackend.entities.enums.TypePhone;

import java.io.Serializable;
import java.util.Objects;

public class PhoneDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String phoneNumber;
    private TypePhone typePhone;
    private String timeAvailability;
    private Long additionalDataId;

    public PhoneDTO() {

    }

    public PhoneDTO(Long id, String phoneNumber, TypePhone typePhone, String timeAvailability, Long additionalDataId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.typePhone = typePhone;
        this.timeAvailability = timeAvailability;
        this.additionalDataId = additionalDataId;
    }
    public PhoneDTO(Phone entity) {
        id=entity.getId();
        phoneNumber=entity.getPhoneNumber();
        typePhone=entity.getTypePhone();
        timeAvailability=entity.getTimeAvailability();
        additionalDataId=entity.getAdditionalData().getId();
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

    public TypePhone getTypePhone() {
        return typePhone;
    }

    public void setTypePhone(TypePhone typePhone) {
        this.typePhone = typePhone;
    }

    public String getTimeAvailability() {
        return timeAvailability;
    }

    public void setTimeAvailability(String timeAvailability) {
        this.timeAvailability = timeAvailability;
    }

    public Long getAdditionalDataId() {
        return additionalDataId;
    }

    public void setAdditionalDataId(Long additionalDataId) {
        this.additionalDataId = additionalDataId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneDTO)) return false;
        PhoneDTO phoneDTO = (PhoneDTO) o;
        return Objects.equals(id, phoneDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

 */
