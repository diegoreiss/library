package com.jpa.relationships.model;

import com.jpa.relationships.dto.photo.PhotoRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Entity(name = "tb_photo")
@Table(name = "tb_photo")
@NoArgsConstructor
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlSmall;
    private String urlMedium;
    private String urlLarge;

    @OneToOne(mappedBy = "photo")
    private Book book;

    public Photo(PhotoRequestDTO data) {
        BeanUtils.copyProperties(data, this);
    }
}
