package com.jpa.relationships.dto.author;

import com.jpa.relationships.model.Author;

import java.util.Date;

public record AuthorResponseDTO(Long id, String firstName, String lastName, Date birthDate) {
    public AuthorResponseDTO(Author author) {
        this(author.getId(), author.getFirstName(), author.getLastName(), author.getBirthDate());
    }
}
