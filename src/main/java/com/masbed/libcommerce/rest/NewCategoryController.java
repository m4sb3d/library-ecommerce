package com.masbed.libcommerce.rest;


import com.masbed.libcommerce.domain.Category;
import com.masbed.libcommerce.rest.contract.NewCategoryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewCategoryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/category")
    @Transactional
    public ResponseEntity<?> newCategory(@RequestBody @Valid NewCategoryRequest newCategoryRequest){
        Category category = newCategoryRequest.toModel();
        entityManager.persist(category);

        return ResponseEntity.ok().body(newCategoryRequest);
    }
}
