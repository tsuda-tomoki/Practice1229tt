package com.example.domain;

import jakarta.validation.constraints.NotBlank;

public class RequestEmployee {
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
