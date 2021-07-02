package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Country;
import com.masbed.libcommerce.rest.contract.NewCountryRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewCountryController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/country")
    @Transactional
    public ResponseEntity<?> newAuthor(@RequestBody @Valid NewCountryRequest newCountryRequest){
        Country country = newCountryRequest.toModel();
        entityManager.persist(country);

        return ResponseEntity.ok().body(newCountryRequest);
    }
}
