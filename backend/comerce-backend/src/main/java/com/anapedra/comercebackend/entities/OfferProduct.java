package com.anapedra.comercebackend.entities;



import javax.persistence.*;
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

    private String offerDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double originalPrice;
    private Double discountOffer;
    @OneToOne
    @MapsId
    private Product product;

    public OfferProduct() {

    }

    public OfferProduct(Long id, String offerDescription, LocalDate startDate, LocalDate endDate,
                        Double originalPrice, Double discountOffer, Product product) {
        this.id = id;
        this.offerDescription = offerDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.originalPrice = originalPrice;
        this.discountOffer = discountOffer;
        this.product = product;
    }

    public Double getOfferPrice(){
       return product.getInitialPrice()-(product.getInitialPrice()*discountOffer);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
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

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Double getDiscountOffer() {
        return discountOffer;
    }

    public void setDiscountOffer(Double discountOffer) {
        this.discountOffer = discountOffer;
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
