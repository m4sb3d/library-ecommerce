package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    @NotBlank
    private String name;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 400)
    private String description;


    public NewAuthorRequest(@NotBlank String name, @NotBlank String email, @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author toModel(){
        return  new Author(this.name,this.email,this.description);
    }
}
