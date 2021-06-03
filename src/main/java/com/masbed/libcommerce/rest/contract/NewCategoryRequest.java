package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Category;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCategoryRequest {

    @NotBlank
    @Exist(domainClass = Category.class, fildname = "name", expected = false)
    private String name;

    @Deprecated
    public NewCategoryRequest(){}

    public NewCategoryRequest(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Category toModel() {
        return new Category(name);
    }
}