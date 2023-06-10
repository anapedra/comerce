package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Catalog;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private Instant momentRegistration;
    private Instant momentUpdate;
    private LocalDate dateRegistration;
    private List<ProductDTO>products=new ArrayList<>();
    private List<OfferProductDTO>offer=new ArrayList<>();

    public CatalogDTO(Long id, Instant momentRegistration, Instant momentUpdate, LocalDate dateRegistration) {
        this.id = id;
        this.momentRegistration = momentRegistration;
        this.momentUpdate = momentUpdate;
        this.dateRegistration = dateRegistration;
    }
    public CatalogDTO() {

    }

    public CatalogDTO(Catalog entity) {
      id= entity.getId();
      momentRegistration=entity.getMomentRegistration();
      momentUpdate=entity.getMomentUpdate();
      dateRegistration=entity.getDateRegistration();
      entity.getProducts().forEach(product -> this.products.add(new ProductDTO(product)));
      entity.getOfferCatalog().forEach(offerProduct -> this.offer.add(new OfferProductDTO()));
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

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
    public List<ProductDTO> getProducts() {
        return products;
    }
    public List<OfferProductDTO> getOffer() {
        return offer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CatalogDTO)) return false;
        CatalogDTO that = (CatalogDTO) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
    /*
    @Size(min = 5, max = 60, message = "Deve ter entre 5 e 60 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;

    @NotBlank(message = "Campo requerido")
    private String description;

    @Positive(message = "Preço deve ser um valor positivo")
    private Double price;

    private String imgUrl;

    @PastOrPresent(message = "A data do produto não pode ser futura")
    private Instant date;

    @NotEmpty(message = "Produto sem categoria não é permitido")
    private List<CategoryDTO> categories = new ArrayList<>();

 */
}
