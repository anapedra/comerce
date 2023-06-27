package com.anapedra.comercebackend.entities;




import com.anapedra.comercebackend.entities.enums.OrderStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private LocalDate dateOrder;
    private Integer status;
    private Double amountDiscount;
    private Double minAmountDiscount;
    private Double totalAmount;
    private Double discountPercent;
    private static int totalVendas;
    @ManyToOne
    @JoinColumn(name = " reportSaleId")
    private ReportSale reportSale;
    @ManyToOne
    @JoinColumn(name = "sellerId")
    private Employee seller;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private User client;
    @OneToMany
    private List<OfferProduct> offerProducts=new ArrayList<>();
    @OneToMany(mappedBy = "id.order")
    private static Set<OrderItem> items=new HashSet<>();


    public Order(Long id, Instant momentRegistration,
                 LocalDate dateOrder, Double amountDiscount, Double minAmountDiscount,
                 OrderStatus status, Double totalAmount, Employee seller,  User client,Double discountPercent,ReportSale reportSale) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateOrder=dateOrder;
        this.minAmountDiscount=minAmountDiscount;
        this.amountDiscount=amountDiscount;
        this.totalAmount = totalAmount;
        this.
        setStatus(status);
        this.seller = seller;
        this.client = client;
        this.discountPercent=discountPercent;
        this.reportSale=reportSale;
        totalVendas++;

    }
    public static int getTotalVendas() {
        return totalVendas;
    }

    public Order() {

    }

    public double getTotal(){
        double soma = 0.0;
        for (OrderItem orderItem : items) {
            soma += orderItem.getSubTotal();
        }
        return totalAmount=soma;
    }

    public double getAmountOfferDiscount(){
        double soma = 0.0;
        for (OfferProduct offerProduct : offerProducts) {
            soma += offerProduct.getDiscountOffer();
        }
        return soma;
    }

    public Double getCalcDiscount(){
        if (getTotal() >= minAmountDiscount){
          return (getTotal()*discountPercent);
        }
        else {
            return 0.0;
        }
    }

    public Double getTotalPayment(){
        return (getTotal()-(getCalcDiscount()+getAmountOfferDiscount()))+getCalcShip();
    }

    public int getQuantityProduct(){
        int soma = 0;
        for (OrderItem orderItem : items) {
            soma += orderItem.getQuantity();
        }
        return soma;
    }

          public Double getCalcShip(){

        if (client.getAddress().getState().equalsIgnoreCase("SP") && getTotal() >= minAmountDiscount*3 && getTotal()<=minAmountDiscount*10){
          return getTotal()*(discountPercent*2);
        }
        else if (client.getAddress().getState().equalsIgnoreCase("SP") && getTotal()< minAmountDiscount*5){
            return getTotal()*(discountPercent*3);
        }

        else if (!getClient().getAddress().getState().equalsIgnoreCase("SP") &&getTotal() >= minAmountDiscount*3 && getTotal()<=minAmountDiscount*10){
            return getTotal()*(discountPercent*4);
        }
        else if (!getClient().getAddress().getState().equalsIgnoreCase("SP") && getTotal()< minAmountDiscount*5){
            return getTotal()*(discountPercent*5);
        }

        else {
            return 0.0;
        }


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


    public List<OfferProduct> getOfferProducts() {
        return offerProducts;
    }

    public void setMomentUpdate(Instant momentUpdate) {
        this.momentUpdate = momentUpdate;
    }

    public Double getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(Double amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getMinAmountDiscount() {
        return minAmountDiscount;
    }

    public void setMinAmountDiscount(Double minAmountDiscount) {
        this.minAmountDiscount = minAmountDiscount;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Employee getSeller() {
        return seller;
    }

    public void setSeller(Employee seller) {
        this.seller = seller;
    }

    public OrderStatus getStatus() {
        return OrderStatus.valueOf(status);
    }

    public void setStatus(OrderStatus status) {
        if (status != null){
        this.status = status.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Double discountPercent) {
        this.discountPercent = discountPercent;
    }


    public ReportSale getReportSale() {
        return reportSale;
    }

    public void setReportSale(ReportSale reportSale) {
        this.reportSale = reportSale;
    }

    public static int setTotalVendas(Integer totalVendas) {
      return   Order.totalVendas = totalVendas;
    }


    public Set<OrderItem> getItems() {
        return items;
    }

    public List<Product> getProducts(){
        return items.stream().map(x->x.getProduct()).toList();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(getId(), order.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
 /*
        if (client.getAddress().getState().equalsIgnoreCase("SP") &&
                getTotal() < ship.getTableShip().getMinAmountFreeShipSP()&&
                getTotal() <= ship.getTableShip().getMinAmountFreeShipSP()/2){
           ship.setCostShip((getTotal()+(getTotal()*ship.getTableShip().getPercentShipSP()))+
                    getTotal()*getShip().getTableShip().getPercentShipSP()*2);
        }
        else if (client.getAddress().getState().equalsIgnoreCase("SP") &&
                getTotal() < getShip().getTableShip().getMinAmountFreeShipSP()&&
                getTotal() > getShip().getTableShip().getMinAmountFreeShipSP()/2){
            ship.setCostShip((getTotal()+(getTotal()*ship.getTableShip().getPercentShipSP())));
        }

        else if (!getClient().getAddress().getState().equalsIgnoreCase("SP") &&
                getTotal() < ship.getTableShip().getMinAmountFreeShipBRAndOutsideSP()&&
                getTotal() <= ship.getTableShip().getMinAmountFreeShipBRAndOutsideSP()/2){
            ship.setCostShip(((getTotal()+(getTotal()*ship.getTableShip().getPercentShipBRAndOutsideSP()))+
                    getTotal()*ship.getTableShip().getPercentShipSP()*2));
        }
        else if (!getClient().getAddress().getState().equalsIgnoreCase("SP") &&
                getTotal() < ship.getTableShip().getMinAmountFreeShipBRAndOutsideSP()&&
                getTotal() > ship.getTableShip().getMinAmountFreeShipBRAndOutsideSP()/2){
           ship.setCostShip((getTotal()+(getTotal()*ship.getTableShip().getPercentShipBRAndOutsideSP())));
        }

        else {
            ship.setCostShip(0.0);
        }
        return ship.getCostShip();
    }
         */