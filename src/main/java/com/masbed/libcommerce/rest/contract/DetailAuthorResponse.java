package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;

public class DetailAuthorResponse {
    private String name;
    private String description;

    public DetailAuthorResponse(Author author) {
        name = author.getName();
        description= author.getDescription();
    }
}
