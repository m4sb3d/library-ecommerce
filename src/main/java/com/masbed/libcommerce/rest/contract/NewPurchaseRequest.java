package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Country;
import com.masbed.libcommerce.domain.Order;
import com.masbed.libcommerce.domain.Purchase;
import com.masbed.libcommerce.domain.State;
import com.masbed.libcommerce.validator.Exist;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewPurchaseRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String city;

    @NotNull
    @Exist(domainClass = Country.class, fildname = "id", expected = true)
    private Long idCountry;

    @NotNull
    @Exist(domainClass = State.class, fildname = "id", expected = true)
    private Long idState;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @NotNull
    @Valid
    private NewOrderRequest order;

    @Deprecated
    public NewPurchaseRequest(){}

    public NewPurchaseRequest(@NotBlank @Email String email, @NotBlank String firstName, @NotBlank String lastName,
                              @NotBlank String document, @NotBlank String address, @NotBlank String city,
                              @NotNull Long idCountry, @NotNull Long idState, @NotBlank String phone, @NotBlank String cep) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.city = city;
        this.idCountry = idCountry;
        this.idState = idState;
        this.phone = phone;
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public NewOrderRequest getOrder() {
        return order;
    }

    public Purchase toModel(){
        Order order = this.order.toModel();
        return new Purchase(email,firstName,lastName, document,address,city,idCountry,idState,phone,cep,order);
    }
}
