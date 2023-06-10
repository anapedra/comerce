package com.anapedra.comercebackend.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class SaleDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Double amount;
    private LocalDate date;
  //  private String sellerName;
//    private String clientName;

    public SaleDTO() {

    }
    public SaleDTO(Long id, Double amount) {
        this.id = id;
        this.amount = amount;
        this.date = date;

    }

    public SaleDTO(OrderDTO entity) {
      id= entity.getId();
      amount= entity.getTotal();
      date=entity.getDateOrder();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleDTO)) return false;
        SaleDTO saleDTO = (SaleDTO) o;
        return Objects.equals(id, saleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


