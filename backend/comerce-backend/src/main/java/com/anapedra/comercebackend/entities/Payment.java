package com.anapedra.comercebackend.entities;

import com.anapedra.comercebackend.entities.enums.TypeFormPayment;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
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

    public Payment(Long id, Instant momentPayment, TypeFormPayment typeFormPayment, Order order) {
        this.id = id;
        this.momentPayment = momentPayment;
        setTypeFormPayment(typeFormPayment);
        this.order = order;
    }

    public Payment() {

    }

    public double getFormPaymentInstallments(double amount){
        typeFormPayment=0;
        switch (typeFormPayment){
            case 1:
                amount=order.getTotal();
                break;
            case 2:
                amount=order.getTotal();
            case 3:
                amount=order.getTotal();
            case 4:
                amount=order.getTotal()/2;
                System.out.println("Sua compra foi parceleda em 2x sem juros\nPrimeira parcela entra na sua procima fatura");
            case 5:
                amount=order.getTotal()/3;
                System.out.println("Sua compra foi parceleda em 3x sem juros\nPrimeira parcela entra na sua procima fatura");
            default:
                System.out.println("Invalid code!");

        }
        return amount;
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
