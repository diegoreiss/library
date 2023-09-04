package com.jpa.relationships.repository;

import com.jpa.relationships.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
