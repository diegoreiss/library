package com.jpa.relationships.dto.book;

import com.jpa.relationships.dto.author.AuthorResponseDTO;
import com.jpa.relationships.dto.category.CategoryResponseDTO;
import com.jpa.relationships.dto.photo.PhotoResponseDTO;
import com.jpa.relationships.model.Book;

import java.util.Collection;
import java.util.Date;

public record BookResponseDTO(
        Long id,
        String title,
        Long isBn,
        Integer totalPages,
        Double rating,
        Date publishedDate,
        PhotoResponseDTO photo,
        Collection<CategoryResponseDTO> categories,
        Collection<AuthorResponseDTO> authors
) {
    public BookResponseDTO(Book book) {
        this(
                book.getId(),
                book.getTitle(),
                book.getIsBn(),
                book.getTotalPages(),
                book.getRating(),
                book.getPublishedDate(),
                new PhotoResponseDTO(book.getPhoto()),
                book.getCategories().stream().map(CategoryResponseDTO::new).toList(),
                book.getAuthors().stream().map(AuthorResponseDTO::new).toList()
        );
    }
}
