package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_additional_data")
public class AdditionalData  implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "additionalData",cascade = CascadeType.ALL)
    private Documents documents;
    @OneToOne(mappedBy = "additionalData",cascade = CascadeType.ALL)
    private PhoneList phoneList;
    @OneToOne(mappedBy = "additionalData",cascade = CascadeType.ALL)
    private AddressList addressList;
    @OneToOne
    @MapsId
    private User user;

    public AdditionalData(Long id, Documents documents, PhoneList phoneList, AddressList addressList, User user) {
        this.id = id;
        this.documents = documents;
        this.phoneList = phoneList;
        this.addressList = addressList;
        this.user = user;
    }

    public AdditionalData() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Documents getDocuments() {
        return documents;
    }

    public void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public PhoneList getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(PhoneList phoneList) {
        this.phoneList = phoneList;
    }

    public AddressList getAddressList() {
        return addressList;
    }

    public void setAddressList(AddressList addressList) {
        this.addressList = addressList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdditionalData)) return false;
        AdditionalData that = (AdditionalData) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
