package com.masbed.libcommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Long idCountry;

    @NotNull
    private Long idState;

    @NotBlank
    private String phone;

    @NotBlank
    private String cep;

    @NotNull
    @OneToOne(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    private Order order;

    @Deprecated
    public Purchase(){
    }

    public Purchase(@NotBlank @Email String email, @NotBlank String firstName, @NotBlank String lastName,
                    @NotBlank String document, @NotBlank String address, @NotBlank String city,
                    @NotNull Long idCountry, @NotNull Long idState, @NotBlank String phone,
                    @NotBlank String cep, @NotNull Order order) {
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
        this.order.setPurchase(this);
    }

    public Long getId() {
        return id;
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
}
