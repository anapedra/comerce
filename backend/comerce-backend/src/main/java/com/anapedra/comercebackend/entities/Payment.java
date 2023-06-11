package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeFormPayment;


import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_paymant")
public class Payment implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant momentPayment;
    private Integer typeFormPayment;
    @OneToOne
    @MapsId
    private Order order;

    public Payment(Long id, Instant  momentPayment, TypeFormPayment typeFormPayment, Order order) {
        this.id = id;
        this.momentPayment = momentPayment;
        setTypeFormPayment(typeFormPayment);
        this.order = order;
    }

    public Payment() {

    }

    public TypeFormPayment getTypeFormPayment() {
        return TypeFormPayment.valueOf(typeFormPayment);
    }

    public void setTypeFormPayment(TypeFormPayment typeFormPayment) {
        if (typeFormPayment != null){
            this.typeFormPayment = typeFormPayment.getCode();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMomentPayment() {
        return momentPayment;
    }

    public void setMomentPayment(Instant momentPayment) {
        this.momentPayment = momentPayment;
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
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
