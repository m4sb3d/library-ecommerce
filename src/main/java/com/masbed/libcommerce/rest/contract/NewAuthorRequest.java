package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    @Exist(domainClass = Author.class, fildname = "email", expected = false)
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;


    public NewAuthorRequest(@NotBlank String name,
                            @NotBlank String email,
                            @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Author toModel(){
        return  new Author(this.name,this.email,this.description);
    }
}
