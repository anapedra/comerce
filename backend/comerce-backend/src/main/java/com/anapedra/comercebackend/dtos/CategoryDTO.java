package com.anapedra.comercebackend.dtos;

import com.anapedra.comercebackend.entities.Category;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Long id;
    private String description;

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
