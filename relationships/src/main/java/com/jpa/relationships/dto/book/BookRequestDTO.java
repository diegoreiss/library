package com.jpa.relationships.dto.book;

import com.jpa.relationships.dto.photo.PhotoRequestDTO;

import java.util.Date;

public record BookRequestDTO(
        String title,
        Long isBn,
        Integer totalPages,
        Double rating,
        Date publishedDate,
        PhotoRequestDTO photo
) {
}
