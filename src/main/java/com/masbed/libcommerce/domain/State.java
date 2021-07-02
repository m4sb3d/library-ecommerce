package com.masbed.libcommerce.domain;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private Long IdCountry;

    @Deprecated
    public State(){

    }

    public State(@NotBlank String name, @NotNull Long idCountry) {
        this.name = name;
        IdCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public Long getIdCountry() {
        return IdCountry;
    }
}
