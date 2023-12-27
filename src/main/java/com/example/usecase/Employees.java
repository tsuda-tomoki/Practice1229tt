package com.example.usecase;

import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

public class Employees {

    private String id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

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
