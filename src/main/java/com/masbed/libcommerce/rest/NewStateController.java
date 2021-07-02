package com.masbed.libcommerce.rest;

import com.masbed.libcommerce.domain.State;
import com.masbed.libcommerce.rest.contract.NewStateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class NewStateController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/api/state")
    @Transactional
    public ResponseEntity<?> newAuthor(@RequestBody @Valid NewStateRequest newStateRequest){
        State state = newStateRequest.toModel();
        entityManager.persist(state);

        return ResponseEntity.ok().body(newStateRequest);
    }
}
