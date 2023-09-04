package com.jpa.relationships.service;

import com.jpa.relationships.model.Author;
import com.jpa.relationships.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
