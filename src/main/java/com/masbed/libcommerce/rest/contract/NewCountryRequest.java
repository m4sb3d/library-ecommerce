package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Country;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCountryRequest {

    @NotBlank
    @Exist(domainClass = Country.class, fildname = "name", expected = false)
    private String name;

    @Deprecated
    public NewCountryRequest(){}

    public NewCountryRequest(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country toModel(){
        return  new Country(name);
    }
}
