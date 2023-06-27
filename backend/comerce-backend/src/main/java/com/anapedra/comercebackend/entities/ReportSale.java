package com.anapedra.comercebackend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_sale")
public class ReportSale implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double totalSale;
    @OneToMany(mappedBy = "reportSale")
    private List<Order>orders=new ArrayList<>();

    public ReportSale(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public ReportSale() {

    }

    public double getSumSale(){
        double soma = 0.0;
        for (Order order : orders) {
            soma = soma+ order.getTotalPayment();
        }
        return totalSale=soma;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(Double totalSale) {
        this.totalSale = totalSale;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReportSale)) return false;
        ReportSale that = (ReportSale) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
