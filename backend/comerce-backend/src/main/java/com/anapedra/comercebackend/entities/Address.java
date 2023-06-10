package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeAddress;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_address_list")
public class Address implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer typeAddress;
    private String road;
    private Integer number;
    private String cep;
    private String neighborhood;
    private String city;
    private String state;
    private String addressComplement;
    @ManyToOne
    @JoinColumn(name = "additionalDataId")
    private AdditionalData additionalData;

    public Address(Long id, TypeAddress typeAddress, String road, Integer number, String cep, String neighborhood,
                   String city, String state, String addressComplement, AdditionalData additionalData) {
        this.id = id;
        setTypeAddress(typeAddress);
        this.road = road;
        this.number = number;
        this.cep = cep;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.addressComplement = addressComplement;
        this.additionalData = additionalData;
    }

    public Address() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public TypeAddress getTypeAddress(){
        return TypeAddress.valueOf(typeAddress);
    }

    public void setTypeAddress(TypeAddress typeAddress) {
        if (typeAddress != null){
            this.typeAddress = typeAddress.getCode();
        }
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

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address that = (Address) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
