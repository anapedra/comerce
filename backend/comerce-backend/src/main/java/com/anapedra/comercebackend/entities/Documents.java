package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_documents")
public class Documents implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpfOrCnpj;
    private String rg;
    private Instant momentRegistration;
    private Instant momentUpdate;
    @OneToOne
    @MapsId
    private AdditionalData additionalData;

    public Documents(Long id, String cpfOrCnpj, String rg, Instant momentRegistration, Instant momentUpdate, AdditionalData additionalData) {
        this.id = id;
        this.cpfOrCnpj = cpfOrCnpj;
        this.rg = rg;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.additionalData = additionalData;
    }

    public Documents() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public AdditionalData getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(AdditionalData additionalData) {
        this.additionalData = additionalData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documents)) return false;
        Documents documents = (Documents) o;
        return Objects.equals(id, documents.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
