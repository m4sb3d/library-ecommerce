package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.domain.Country;
import com.masbed.libcommerce.domain.State;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewStateRequest {


    @NotBlank
    @Exist(domainClass = State.class, fildname = "name", expected = false)
    private String name;

    @NotNull
    @Exist(domainClass = Country.class, fildname = "id", expected = true)
    private Long idCountry;

    @Deprecated
    public  NewStateRequest(){}

    public NewStateRequest(@NotBlank String name, @NotNull Long idCountry) {
        this.name = name;
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public State toModel(){
        return new State(name, idCountry);
    }
}
