package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.AdditionalData;
import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.Order;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserClientDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String name;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private String mainPhone;
    private String registrationEmail;
    private AdditionalDataDTO additionalData;
    private List<OrderDTO> orders=new ArrayList<>();


    public UserClientDTO() {

    }

    public UserClientDTO(Long id, String name, Instant momentRegistration, Instant momentUpdate,
                         String mainPhone, String registrationEmail, AdditionalDataDTO additionalData) {
        this.id = id;
        this.name = name;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.mainPhone = mainPhone;
        this.registrationEmail = registrationEmail;
        this.additionalData = additionalData;
    }

    public UserClientDTO(Employee entity) {
      id=entity.getId();
      name=entity.getName();
      momentRegistration=entity.getMomentRegistration();
      momentUpdate=entity.getMomentUpdate();
      mainPhone=entity.getMainPhone();
      registrationEmail=entity.getRegistrationEmail();
      additionalData=new AdditionalDataDTO(entity.getAdditionalData().getId(),
              entity.getAdditionalData().getDocuments(),
              entity.getAdditionalData().getPhoneList(),
              entity.getAdditionalData().getAddressList());
    }

    public UserClientDTO(Employee entity, List<Order> orders){
        this(entity);
        entity.getOrders().forEach(order -> this.orders.add(new OrderDTO(order)));

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

    public String getRegistrationEmail() {
        return registrationEmail;
    }

    public void setRegistrationEmail(String registrationEmail) {
        this.registrationEmail = registrationEmail;
    }

    public AdditionalDataDTO getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalDataDTO additionalData) {
        this.additionalData = additionalData;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserClientDTO)) return false;
        UserClientDTO that = (UserClientDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
