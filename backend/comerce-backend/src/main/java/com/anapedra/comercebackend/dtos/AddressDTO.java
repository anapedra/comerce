package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Address;
import com.anapedra.comercebackend.entities.enums.TypeAddress;

import java.util.Objects;

public class AddressDTO {
    private Long id;
    private String addressPersonName;
    private TypeAddress typeAddress;
    private String road;
    private Integer number;
    private String cep;
    private String neighborhood;
    private String city;
    private String state;
    private String addressComplement;
    private Long additionalData;


    public AddressDTO() {

    }

    public AddressDTO(Long id, String addressPersonName, TypeAddress typeAddress, String road, Integer number, String cep, String neighborhood,
                      String city, String state, String addressComplement, Long additionalData) {
        this.id = id;
        this.addressPersonName = addressPersonName;
        this.typeAddress = typeAddress;
        this.road = road;
        this.number = number;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.addressComplement = addressComplement;
        this.additionalData = additionalData;
    }

    public AddressDTO(Address entity) {
      id= entity.getId();

      typeAddress=entity.getTypeAddress();
      road=entity.getStreet();
      number=entity.getNumber();
      cep=entity.getCep();
      neighborhood=entity.getBorhood();
      city=entity.getCity();
      state=entity.getState();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressPersonName() {
        return addressPersonName;
    }

    public void setAddressPersonName(String addressPersonName) {
        this.addressPersonName = addressPersonName;
    }

    public TypeAddress getTypeAddress() {
        return typeAddress;
    }

    public void setTypeAddress(TypeAddress typeAddress) {
        this.typeAddress = typeAddress;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAddressComplement() {
        return addressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        this.addressComplement = addressComplement;
    }

    public Long getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Long additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDTO)) return false;
        AddressDTO that = (AddressDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


