package com.example.Exception;

public class EmployeesNotFoundException extends RuntimeException{
    public EmployeesNotFoundException(String message) {
        super(message);
    }
}
