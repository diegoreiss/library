package com.jpa.relationships.dto.book;

import com.jpa.relationships.model.Author;
import com.jpa.relationships.model.Photo;

import java.util.Collection;
import java.util.Date;

public record BookDTO(
        Long id,
        String title,
        Long isBn,
        Integer totalPages,
        Double rating,
        Date publishedDate,
        Collection<Author> authors
) {
}
