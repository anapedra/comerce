package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeAddress;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer typeAddress;
    private String street;
    private Integer number;
    private String cep;
    private String borhood;
    private String city;
    private String state;
    private String AddressComplement;
    @OneToMany(mappedBy = "address")
    private List<User>clients=new ArrayList<>();



    public Address(Long id, TypeAddress typeAddress, String street, Integer number, String cep, String borhood,
                   String city, String state, String addressComplement) {
        this.id = id;
        setTypeAddress(typeAddress);
        this.street=street;
        this.number = number;
        this.cep = cep;
        this.borhood = borhood;
        this.city = city;
        this.state = state;
        this.AddressComplement=addressComplement;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getBorhood() {
        return borhood;
    }

    public void setBorhood(String borhood) {
        this.borhood = borhood;
    }

    public String getAddressComplement() {
        return AddressComplement;
    }

    public void setAddressComplement(String addressComplement) {
        AddressComplement = addressComplement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
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


