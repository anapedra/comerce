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
    private Double discountOffer;
    @ManyToOne
    @JoinColumn(name = "catalogId")
    private Catalog catalog;
    @OneToOne
    @MapsId
    private Product product;
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    public OfferProduct() {

    }

    public OfferProduct(Long id, String offerDescription, LocalDate startDate,
                        LocalDate endDate, Double discountOffer, Catalog catalog, Product product, Order order) {
        this.id = id;
        this.offerDescription = offerDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.discountOffer = discountOffer;
        this.catalog = catalog;
        this.product = product;
        this.order = order;
    }

    public double amountDiscountOffer(){
        return product.getInitialPrice()*discountOffer;
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

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
