package com.jpa.relationships.service;

import com.jpa.relationships.model.Photo;
import com.jpa.relationships.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> findAll() {
        return photoRepository.findAll();
    }

    public Photo findById(Long id) {
        return photoRepository.findById(id).get();
    }

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
}
