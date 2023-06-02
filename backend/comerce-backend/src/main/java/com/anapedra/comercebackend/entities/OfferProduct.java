package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_offer_product")
public class OfferProduct implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double priceOffer;
    private LocalDate startDate;
    private LocalDate endDate;
    @OneToOne
    @MapsId
    private Product product;

    public OfferProduct(Long id, Double priceOffer, LocalDate startDate, LocalDate endDate, Product product) {
        this.id = id;
        this.priceOffer = priceOffer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.product = product;
    }

    public OfferProduct() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPriceOffer() {
        return priceOffer;
    }

    public void setPriceOffer(Double priceOffer) {
        this.priceOffer = priceOffer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferProduct)) return false;
        OfferProduct that = (OfferProduct) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
