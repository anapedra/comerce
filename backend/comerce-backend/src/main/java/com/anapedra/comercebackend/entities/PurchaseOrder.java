package com.anapedra.comercebackend.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_purchase_orde")
public class PurchaseOrder implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private LocalDate dateOrder;
    @ManyToOne
    @JoinColumn(name = "purchasingAdministrator_id")
    private Employee purchasingAdministrator;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private User supplier;
    @OneToMany(mappedBy = "id.purchaseOrder")
    private Set<PurchaseOrderItem> purchaseOrderItems=new HashSet<>();

    public PurchaseOrder(Long id, Instant momentRegistration,
                         Instant momentUpdate, LocalDate dateOrder, Employee purchasingAdministrator, User supplier) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateOrder = dateOrder;
        this.purchasingAdministrator = purchasingAdministrator;
        this.supplier = supplier;
    }

    public PurchaseOrder() {

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

    public Employee getPurchasingAdministrator() {
        return purchasingAdministrator;
    }

    public void setPurchasingAdministrator(Employee purchasingAdministrator) {
        this.purchasingAdministrator = purchasingAdministrator;
    }

    public User getSupplier() {
        return supplier;
    }

    public void setSupplier(User supplier) {
        this.supplier = supplier;
    }

    public Set<PurchaseOrderItem> getPurchaseOrderItems() {
        return purchaseOrderItems;
    }
    public List<Product> getProducts(){
        return purchaseOrderItems.stream().map(x->x.getProduct()).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrder)) return false;
        PurchaseOrder that = (PurchaseOrder) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
