package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.*;
import com.anapedra.comercebackend.entities.enums.OrderStatus;
import com.anapedra.comercebackend.entities.enums.TypeFormPayment;
import org.apache.juli.logging.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Instant momentRegistration;
    private Long id;
    private Long clientId;
    private Long sellerId;
    private Instant momentUpdate;
    private LocalDate dateOrder;
    private OrderStatus status;
    private String selleName;
    private String clientName;
    private String cpfClint;
    private String phoneClient;
    private Double total;
    private Integer quantityProduct;
    private Double discount;
    private Double amountDiscountOffer;
    private Double shippingCost;
    private Double totalPayment;
    private Double amountDiscount;
    private Double minAmountDiscount;

    private List<OfferProductDTO>offerProducts=new ArrayList<>();
    private List<OrderItemDTO> items=new ArrayList<>();

    public OrderDTO() {

    }


    public OrderDTO(Instant momentRegistration, Long id, Long clientId, Long sellerId, Instant momentUpdate,
                    LocalDate dateOrder, OrderStatus status, String selleName, String clientName, String cpfClint,
                    String phoneClient, Double total, Integer quantityProduct, Double discount, Double amountDiscountOffer,
                    Double shippingCost, Double totalPayment, Double amountDiscount, Double minAmountDiscount) {
        this.momentRegistration = momentRegistration;
        this.id = id;
        this.clientId = clientId;
        this.sellerId = sellerId;
        this.momentUpdate = momentUpdate;
        this.dateOrder = dateOrder;
        this.status = status;
        this.selleName = selleName;
        this.clientName = clientName;
        this.cpfClint = cpfClint;
        this.phoneClient = phoneClient;
        this.total = total;
        this.quantityProduct = quantityProduct;
        this.discount = discount;
        this.amountDiscountOffer = amountDiscountOffer;
        this.shippingCost = shippingCost;
        this.totalPayment = totalPayment;
        this.amountDiscount = amountDiscount;
        this.minAmountDiscount = minAmountDiscount;
    }

    public OrderDTO(Order entity) {
        id=entity.getId();
        clientName = entity.getClient().getName();
        cpfClint=entity.getClient().getCpf();
        selleName=entity.getSeller().getName();
        phoneClient=entity.getClient().getMainPhone();
        momentRegistration=entity.getMomentRegistration();
        dateOrder=entity.getDateOrder();
        status=entity.getStatus();
        quantityProduct=entity.getQuantityProduct();
        amountDiscount=entity.getCalcDiscount();
        discount=entity.getDiscountPercent();
        minAmountDiscount=entity.getMinAmountDiscount();
        totalPayment=entity.getTotalPayment();
        total= entity.getTotal();
        clientId=entity.getClient().getId();
        sellerId=entity.getSeller().getId();
        shippingCost=entity.getCalcShip();


    }

    public OrderDTO(Order entity,Set<OrderItem> orderItems,List<OfferProduct> offerProducts){
        this(entity);
        entity.getOfferProducts().forEach(offerProduct -> this.offerProducts.add(new OfferProductDTO(offerProduct)));
        entity.getItems().forEach(orderItem -> this.items.add(new OrderItemDTO(orderItem)));
        clientId=entity.getClient().getId();
        sellerId=entity.getSeller().getId();
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

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getSelleName() {
        return selleName;
    }

    public String getClientName() {
        return clientName;
    }

    public Double getAmountDiscount() {
        return amountDiscount;
    }

    public Double getAmountDiscountOffer() {
        return amountDiscountOffer;
    }

    public void setAmountDiscountOffer(Double amountDiscountOffer) {
        this.amountDiscountOffer = amountDiscountOffer;
    }

    public List<OfferProductDTO> getOfferProducts() {
        return offerProducts;
    }

    public void setOfferProducts(List<OfferProductDTO> offerProducts) {
        this.offerProducts = offerProducts;
    }
    /*
    public void setAmountDiscount(Double amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

 */

    public Double getMinAmountDiscount() {
        return minAmountDiscount;
    }
    public void setMinAmountDiscount(Double minAmountDiscount) {
        this.minAmountDiscount = minAmountDiscount;
    }

 //   public void setFormPayment(TypeFormPayment formPayment) {
  //      this.formPayment = formPayment;
   // }
    public String getCpfClint() {
        return cpfClint;
    }

    public String getPhoneClient() {
        return phoneClient;
    }

    public Long getClientId() {
        return clientId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getShippingCost() {
        return shippingCost;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public Double getTotal() {
        return total;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDTO)) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(getId(), orderDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public void setSelleName(String selleName) {
        this.selleName = selleName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public void setCpfClint(String cpfClint) {
        this.cpfClint = cpfClint;
    }

    public void setPhoneClient(String phoneClient) {
        this.phoneClient = phoneClient;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setShippingCost(Double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setAmountDiscount(Double amountDiscount) {
        this.amountDiscount = amountDiscount;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
