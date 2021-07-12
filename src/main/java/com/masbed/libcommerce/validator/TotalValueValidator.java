package com.masbed.libcommerce.validator;

import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.rest.contract.NewItemRequest;
import com.masbed.libcommerce.rest.contract.NewPurchaseRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class TotalValueValidator implements Validator {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NewPurchaseRequest.class.isAssignableFrom(clazz);
    }


    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) return;

        double totalPurchase = 0;

        NewPurchaseRequest newPurchaseRequest= (NewPurchaseRequest) target;
        Query query  = entityManager.createQuery("SELECT l FROM Book l WHERE id = :bookId");

        for(NewItemRequest newItemRequest : newPurchaseRequest.getOrder().getNewItemRequestList()) {
            query.setParameter("bookId", newItemRequest.getIdBook());
            Book book = (Book) query.getSingleResult();

            totalPurchase += book.getPrice().doubleValue() *  newItemRequest.getQuantity();

        }

        if(totalPurchase != newPurchaseRequest.getOrder().getTotal().doubleValue()) {
            errors.rejectValue("order.total", null, "deve ser igual a soma do preço dos itens");

        }

    }
}
