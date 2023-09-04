package com.jpa.relationships.dto.book;

import com.jpa.relationships.dto.author.AuthorResponseDTO;
import com.jpa.relationships.model.Book;

import java.util.Collection;
import java.util.Date;

public record BookResponseWithAuthorsDTO(
        String title,
        Long isBn,
        Integer totalPages,
        Double rating,
        Date publishedDate,
        Collection<AuthorResponseDTO> authors
) {
    public BookResponseWithAuthorsDTO(Book book) {
        this(
                book.getTitle(),
                book.getIsBn(),
                book.getTotalPages(),
                book.getRating(),
                book.getPublishedDate(),
                book.getAuthors().stream().map(AuthorResponseDTO::new).toList()
        );
    }
}
