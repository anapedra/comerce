package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

public class ProductAdministrationDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private String shortDescription;
    private String fullDescription;
    private Double productCost;
    private Double initialPrice;
    private String imgUrl;
    private OfferProductDTO offerProduct;
    private List<CategoryDTO> categories=new ArrayList<>();



    public ProductAdministrationDTO() {

    }

    public ProductAdministrationDTO(Long id, Instant momentRegistration, Instant momentUpdate, String shortDescription, String fullDescription,
                                    Double productCost, Double initialPrice, String imgUrl, OfferProductDTO offerProduct) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.productCost = productCost;
        this.initialPrice = initialPrice;
        this.imgUrl = imgUrl;
        this.offerProduct = offerProduct;
    }
    public ProductAdministrationDTO(Product entity){
        id=entity.getId();
        momentRegistration=entity.getMomentRegistration();
        momentUpdate=entity.getMomentUpdate();
        shortDescription=entity.getShortDescription();
        fullDescription=entity.getFullDescription();
        productCost=entity.getProductCost();
        initialPrice= entity.getInitialPrice();
        imgUrl=entity.getImgUrl();


    }
    public ProductAdministrationDTO(Product entity, Set<Category> categories){
        this(entity);
        entity.getCategories().forEach(category -> this.categories.add(new CategoryDTO(category)));


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

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public OfferProductDTO getOfferProduct() {
        return offerProduct;
    }

    public void setOfferProduct(OfferProductDTO offerProduct) {
        this.offerProduct = offerProduct;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductAdministrationDTO)) return false;
        ProductAdministrationDTO that = (ProductAdministrationDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
