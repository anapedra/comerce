package com.anapedra.comercebackend.entities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_additional_data")
public class AdditionalData  implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private User user;
    @OneToMany(mappedBy = "additionalData")
    private List<Phone> phones=new ArrayList<>();
    @OneToMany(mappedBy = "additionalData")
    private List<Address>addresses=new ArrayList<>();
    @OneToMany(mappedBy = "additionalData")
    private List<Email> emails=new ArrayList<>();

    public AdditionalData(Long id, User user) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public List<Email> getEmails() {
        return emails;
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
