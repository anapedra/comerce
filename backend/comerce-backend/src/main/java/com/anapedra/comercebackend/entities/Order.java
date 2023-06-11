package com.anapedra.comercebackend.entities;




import com.anapedra.comercebackend.entities.enums.OrderStatus;
import com.anapedra.comercebackend.entities.enums.TypeFormPayment;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static com.anapedra.comercebackend.entities.enums.TypeFormPayment.PIX;

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
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Employee seller;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Ship ship;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    @OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
    private Payment payment;
    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items=new HashSet<>();


    public Order(Long id, Instant momentRegistration, Instant momentUpdate, LocalDate dateOrder, Integer status, Double amountDiscount,
                 Double minAmountDiscount, Employee seller, Ship ship, User client, Payment payment) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateOrder = dateOrder;
        this.status = status;
        this.amountDiscount = amountDiscount;
        this.minAmountDiscount = minAmountDiscount;
        this.seller = seller;
        this.ship = ship;
        this.client = client;
        this.payment = payment;
    }

    public Order(Long id, Instant momentRegistration, Instant momentUpdate,
                 LocalDate dateOrder,Double amountDiscount,Double minAmountDiscount,
                 OrderStatus status, Employee seller, Ship ship, User client) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateOrder=dateOrder;
        this.minAmountDiscount=minAmountDiscount;
        this.amountDiscount=amountDiscount;
        this.
        setStatus(status);
        this.seller = seller;
        this.ship=ship;
        this.client = client;

    }

    public Order() {

    }



    public double getTotal(){
        double soma = 0.0;
        for (OrderItem orderItem : items) {
            soma += orderItem.getSubTotal();
        }
        return soma;
    }

    public Double calcDiscount(){
        if (payment.getTypeFormPayment() == PIX && getTotal() > minAmountDiscount){
          return (getTotal()*amountDiscount);
        }
        else {
            return 0.0;
        }
    }

    public double getTotalPayment(){
       return  getTotal()+ship.getCostShip()-calcDiscount();
    }

    public int getQuantityProduct(){
        int soma = 0;
        for (OrderItem orderItem : items) {
            soma += orderItem.getQuantity();
        }
        return soma;
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

    public Double getAmountDiscount() {
        return amountDiscount;
    }

    public void setAmountDiscount(Double amountDiscount) {
        this.amountDiscount = amountDiscount;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
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
