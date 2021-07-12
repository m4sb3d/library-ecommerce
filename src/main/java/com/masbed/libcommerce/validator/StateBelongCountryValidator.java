package com.masbed.libcommerce.validator;

import com.masbed.libcommerce.rest.contract.NewPurchaseRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class StateBelongCountryValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPurchaseRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        NewPurchaseRequest newPurchaseRequest= (NewPurchaseRequest) target;

        Query query = entityManager.createQuery("SELECT 1 FROM State WHERE id = :stateId AND country_id = :countryId");
        query.setParameter("stateId", newPurchaseRequest.getIdState());
        query.setParameter("countryId", newPurchaseRequest.getIdCountry());

        List<?> result = query.getResultList();
        boolean exists = result.size() > 0;

        if(!exists) errors.rejectValue("stateId", null, "O estado deve pertencer ao pais enviado");

    }
}
