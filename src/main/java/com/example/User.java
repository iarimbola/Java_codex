package com.example;

import io.micronaut.serde.annotation.Serdeable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.util.Objects;

import static jakarta.persistence.GenerationType.AUTO;
@Serdeable
@Entity
@Table(name = "users")
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "lastName", nullable = false)
    private  String lastName;

    @NotNull
    @Column(name = "firstName", nullable = false)
    private  String firstName;

    public User() {}

    public User(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void  setId(Long id) {
        Objects.requireNonNull(id);
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName);
        this.lastName = lastName;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName);
        this.firstName = firstName;
    }



}