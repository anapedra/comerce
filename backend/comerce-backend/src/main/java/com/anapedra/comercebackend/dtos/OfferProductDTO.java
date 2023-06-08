package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.OfferProduct;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class OfferProductDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String offerDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private String productShotDescription;
    private Double originalPrice;
    private Double discountOffer;
    private Double offerPrice;


    public OfferProductDTO() {

    }

    public OfferProductDTO(Long id, String offerDescription, LocalDate startDate, LocalDate endDate, String productShotDescription,
                           Double originalPrice, Double discountOffer, Double offerPrice) {
        this.id = id;
        this.offerDescription = offerDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productShotDescription = productShotDescription;
        this.originalPrice = originalPrice;
        this.discountOffer = discountOffer;
        this.offerPrice = offerPrice;
    }

    public OfferProductDTO(OfferProduct entity){
        id=entity.getId();
        offerDescription= entity.getOfferDescription();
        startDate=entity.getStartDate();
        endDate=entity.getEndDate();
        productShotDescription= entity.getProduct().getShortDescription();
        originalPrice=entity.getProduct().getInitialPrice();
        discountOffer=entity.getDiscountOffer();
        offerPrice=entity.getOfferPrice();
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

    public String getProductShotDescription() {
        return productShotDescription;
    }

    public void setProductShotDescription(String productShotDescription) {
        this.productShotDescription = productShotDescription;
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

    public Double getOfferPrice() {
        return offerPrice;
    }

    public void setOfferPrice(Double offerPrice) {
        this.offerPrice = offerPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OfferProductDTO)) return false;
        OfferProductDTO that = (OfferProductDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
