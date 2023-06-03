package com.anapedra.comercebackend.entities.pk;

import com.anapedra.comercebackend.entities.Product;
import com.anapedra.comercebackend.entities.PurchaseOrder;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseOrderItemPK  implements Serializable {
    private static final long serialVersionUID=1L;
    @ManyToOne
    @JoinColumn(name = "purchaseOrder_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public PurchaseOrderItemPK() {

    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
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
        if (!(o instanceof PurchaseOrderItemPK)) return false;
        PurchaseOrderItemPK that = (PurchaseOrderItemPK) o;
        return Objects.equals(purchaseOrder, that.purchaseOrder) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseOrder, product);
    }
}
