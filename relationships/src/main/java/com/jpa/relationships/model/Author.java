package com.jpa.relationships.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Data
@Entity(name = "tb_author")
@Table(name = "tb_author")
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthDate;

    @ManyToMany(mappedBy = "authors")
    private Collection<Book> books;
}
