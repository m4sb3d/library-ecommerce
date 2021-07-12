package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.Purchase;
import com.masbed.libcommerce.rest.contract.NewPurchaseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
public class NewPurchaseController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "api/buy" )
    @Transactional
    public ResponseEntity<?> newPurchase(@RequestBody @Valid NewPurchaseRequest newPurchaseRequest, UriComponentsBuilder builder) {
        Purchase purchase = newPurchaseRequest.toModel();
        URI addressQuery =  builder.path("api/buy/{id}").build(purchase.getId());

        return ResponseEntity.created(addressQuery).build();
    }
}
