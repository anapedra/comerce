package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private Integer status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items=new HashSet<>();

    public Order(Long id, Instant momentRegistration, Instant momentUpdate, OrderStatus status, User client) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        setStatus(status);
        this.client = client;

    }

    public Order() {

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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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
