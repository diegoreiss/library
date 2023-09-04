package com.jpa.relationships.dto.photo;

import com.jpa.relationships.model.Photo;

public record PhotoResponseDTO(Long id, String urlSmall, String urlMedium, String urlLarge) {
    public PhotoResponseDTO(Photo photo) {
        this(photo.getId(), photo.getUrlSmall(), photo.getUrlMedium(), photo.getUrlLarge());
    }
}
