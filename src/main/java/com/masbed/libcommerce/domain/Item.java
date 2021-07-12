package com.masbed.libcommerce.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
public class Item {

    @NotNull
    private Long idBook;

    @NotNull
    @Positive
    private Long quantity;

    @Deprecated
    public Item(){}

    public Item(@NotNull Long idBook, @NotNull @Positive Long quantity) {
        this.idBook = idBook;
        this.quantity = quantity;
    }

    public Long getIdBook() {
        return idBook;
    }

    public Long getQuantity() {
        return quantity;
    }
}

