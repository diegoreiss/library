package com.jpa.relationships.dto.photo;

public record PhotoRequestDTO(
        String urlSmall,
        String urlMedium,
        String urlLarge
) {
}
