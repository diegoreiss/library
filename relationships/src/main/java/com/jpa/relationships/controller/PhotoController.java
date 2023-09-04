package com.jpa.relationships.controller;

import com.jpa.relationships.dto.photo.PhotoRequestDTO;
import com.jpa.relationships.dto.photo.PhotoResponseDTO;
import com.jpa.relationships.model.Photo;
import com.jpa.relationships.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @GetMapping
    public ResponseEntity<Object> retrieveAllPhotos() {
        List<PhotoResponseDTO> photos = photoService.findAll()
                .stream()
                .map(PhotoResponseDTO::new)
                .toList();

        return ResponseEntity.ok(photos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoResponseDTO> retrieveById(@PathVariable Long id) {
        Photo photo = photoService.findById(id);

        return ResponseEntity.ok(new PhotoResponseDTO(photo));
    }

    @PostMapping
    public ResponseEntity<Object> createPhoto(@RequestBody PhotoRequestDTO body) {
        Photo newPhoto = photoService.save(new Photo(body));

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPhoto.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
