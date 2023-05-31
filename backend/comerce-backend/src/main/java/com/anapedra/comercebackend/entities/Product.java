package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private String shortDescription;
    private String fullDescription;
    private Double productCost;
    private Double initialPrice;
    private String imgUrl;
    @ManyToMany
    @JoinTable(name = "tb_product_category",joinColumns =
    @JoinColumn(name = "product_id"),inverseJoinColumns =
    @JoinColumn(name = "category_id"))
    private Set<Category>categories=new HashSet<>();
    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items=new HashSet<>();

    public Product(Long id, String shortDescription, String fullDescription, Instant momentRegistration,
                   Instant momentUpdate, Double productCost, Double initialPrice, String imgUrl) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.productCost = productCost;
        this.initialPrice = initialPrice;
        this.imgUrl = imgUrl;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public Set<OrderItem> getItems() {
        return items;
    }
    public List<Order> getOrders(){
        return items.stream().map(x->x.getOrder()).toList();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }





}
