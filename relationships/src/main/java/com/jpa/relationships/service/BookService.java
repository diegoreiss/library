package com.jpa.relationships.service;

import com.jpa.relationships.model.Book;
import com.jpa.relationships.repository.AuthorRepository;
import com.jpa.relationships.repository.BookRepository;
import com.jpa.relationships.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void findAllWithAuthors() {
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
