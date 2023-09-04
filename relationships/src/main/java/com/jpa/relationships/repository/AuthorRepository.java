package com.jpa.relationships.repository;

import com.jpa.relationships.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
