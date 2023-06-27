package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.OrderItem;
import com.anapedra.comercebackend.entities.pk.OrderItemPK;

import java.io.Serializable;
import java.util.Objects;

public class OrderItemDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private OrderItemPK id=new OrderItemPK();
    private Integer quantity;
    private Double price;
    private Double subTotal;
    private String productName;
    private String imgUrl;


    public OrderItemDTO() {

    }

    public OrderItemDTO( Integer quantity, Double price, Double subTotal, String productName,String imgUrl) {
        this.quantity = quantity;
        this.price = price;
        this.subTotal = subTotal;
        this.productName = productName;
        this.imgUrl=imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productName=entity.getProduct().getShortDescription();
        quantity= entity.getQuantity();
        price= entity.getPrice();
        subTotal=entity.getSubTotal();
        imgUrl=entity.getProduct().getImgUrl();

    }



    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
