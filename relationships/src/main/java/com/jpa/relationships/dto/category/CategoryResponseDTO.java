package com.jpa.relationships.dto.category;

import com.jpa.relationships.model.Category;

import java.util.Collection;

public record CategoryResponseDTO(
        Long id,
        String category,
        Long parentId,
        Collection<Category> parent
) {
    public CategoryResponseDTO(Category category) {
        this(category.getId(), category.getCategory(), category.getParent().getId(), category.getChildren());
    }
}
