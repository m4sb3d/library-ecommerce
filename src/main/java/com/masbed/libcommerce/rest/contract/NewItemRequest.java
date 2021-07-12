package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Book;
import com.masbed.libcommerce.domain.Item;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NewItemRequest {

    @NotNull
    @Exist(domainClass = Book.class, fildname = "id", expected = true)
    private Long idBook;

    @NotNull
    @Positive
    private Long quantity;

    public Long getIdBook() {
        return idBook;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Item toModel(){
        return new Item(idBook,quantity);
    }
}
