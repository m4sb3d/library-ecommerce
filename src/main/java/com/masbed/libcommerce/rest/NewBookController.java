package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.rest.contract.NewAuthorRequest;
import com.masbed.libcommerce.rest.contract.NewBookRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewBookController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/book")
    @Transactional
    public ResponseEntity<?> newBook(@RequestBody @Valid NewBookRequest newBookRequest){
        Book book = newBookRequest.toModel(entityManager);
        entityManager.persist(book);

        return ResponseEntity.ok().body(newBookRequest);
    }
}
