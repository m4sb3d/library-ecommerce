package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.rest.contract.NewAuthorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/author")
    @Transactional
    public ResponseEntity<?> newAuthor(@RequestBody @Valid NewAuthorRequest newAuthorRequest){
        Author author = newAuthorRequest.toModel();
        entityManager.persist(author);

        return ResponseEntity.ok().body(newAuthorRequest);
    }
}
