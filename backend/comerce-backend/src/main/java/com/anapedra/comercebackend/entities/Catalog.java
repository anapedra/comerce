package com.anapedra.comercebackend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_product_catalog")
public class Catalog implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private LocalDate dateRegistration;
    @OneToMany(mappedBy = "catalog")
    private List<Product>products=new ArrayList<>();
    @OneToMany(mappedBy = "catalog")
    private List<OfferProduct>offerCatalog=new ArrayList<>();

    public Catalog(Long id, Instant momentRegistration, Instant momentUpdate, LocalDate dateRegistration) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateRegistration = dateRegistration;
    }

    public Catalog() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<OfferProduct> getOfferCatalog() {
        return offerCatalog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Catalog)) return false;
        Catalog catalog = (Catalog) o;
        return Objects.equals(id, catalog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
