package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RestController
public class ListBooksController {

    @PersistenceContext
    private EntityManager entityManager;
    @GetMapping(value = "/api/book")
    public ResponseEntity<?> bookList() {
        Query query = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        List<Book> books = query.getResultList();

        return ResponseEntity.ok().body(books);
    }
}
