package com.jpa.relationships.controller;

import com.jpa.relationships.dto.book.BookRequestDTO;
import com.jpa.relationships.dto.book.BookResponseDTO;
import com.jpa.relationships.dto.book.BookResponseWithAuthorsDTO;
import com.jpa.relationships.model.Author;
import com.jpa.relationships.model.Book;
import com.jpa.relationships.model.Photo;
import com.jpa.relationships.service.AuthorService;
import com.jpa.relationships.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> retrieveAll() {
        List<BookResponseDTO> bookResponseDTOList = bookService.findAll().stream()
                .map(BookResponseDTO::new)
                .toList();

        return ResponseEntity.ok(bookResponseDTOList);
    }

    @GetMapping("/author")
    public ResponseEntity<List<BookResponseWithAuthorsDTO>> retrieveAllWithAuthors() {
        List<BookResponseWithAuthorsDTO> bookRequestWithAuthorsDTOList = bookService.findAll().stream()
                .map(BookResponseWithAuthorsDTO::new)
                .toList();

        return ResponseEntity.ok(bookRequestWithAuthorsDTOList);
    }

    @PostMapping("/photo")
    public ResponseEntity<Object> createBookWithPhoto(@RequestBody BookRequestDTO body, UriComponentsBuilder uriBuilder) {
        Photo newPhoto = new Photo(body.photo());
        Book newBook = new Book(body);
        newBook.setPhoto(newPhoto);

        Book saveBook = bookService.save(newBook);

        URI uri = uriBuilder.path("/book/{id}/photo/{photoId}")
                .buildAndExpand(saveBook.getId(), saveBook.getPhoto().getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/author/{authorId}")
    public ResponseEntity<Object> createBookWithExistentAuthor(@RequestBody BookRequestDTO body, @PathVariable Long authorId, UriComponentsBuilder uriBuilder) {
        Author existentAuthor = authorService.findById(authorId);
        Book newBook = bookService.save(new Book(body, Collections.singletonList(existentAuthor)));

        URI uri = uriBuilder.path("/book/{id}/author/{authorId}").buildAndExpand(newBook.getId(), authorId).toUri();

        return ResponseEntity.created(uri).build();
    }

}
