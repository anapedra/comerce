package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.pk.PurchaseOrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_purchase_order_item")
public class PurchaseOrderItem implements Serializable {
    private static final long serialVersionUID=1L;

    @EmbeddedId
    private PurchaseOrderItemPK id=new PurchaseOrderItemPK();
    private Integer quantity;
    private Double price;

    public PurchaseOrderItem(PurchaseOrder purchaseOrder,Product product,Integer quantity, Double price) {
        id.setPurchaseOrder(purchaseOrder);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public PurchaseOrderItem() {

    }
    public PurchaseOrder getPurchaseOrder(){
        return id.getPurchaseOrder();
    }
    public void setPurchaseOrder(PurchaseOrder purchaseOrder){
        id.setPurchaseOrder(purchaseOrder);
    }
    public Product getProduct(){
        return id.getProduct();
    }
    public void setProduct(Product product){
        id.setProduct(product);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrderItem)) return false;
        PurchaseOrderItem that = (PurchaseOrderItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
