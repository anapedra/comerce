package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Category;
import com.anapedra.comercebackend.entities.Product;

import java.io.Serializable;
import java.util.*;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String description;
    //private Set<ProductDTO>productDTOS=new HashSet<>();

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String description) {
        this.id = id;
        this.description = description;

    }

    public CategoryDTO(Category entity) {
     id=entity.getId();
     description= entity.getDescription();
    }
/*
    public CategoryDTO(Category entity, Set<Product>products){
        this(entity);
        entity.getProducts().forEach(product -> this.productDTOS.add(new ProductDTO(product)));
    }

 */



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /*

    public Set<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDTO)) return false;
        CategoryDTO that = (CategoryDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
