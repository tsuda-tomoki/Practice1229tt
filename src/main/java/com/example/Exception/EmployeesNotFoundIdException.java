package com.example.Exception;

public class EmployeesNotFoundIdException extends RuntimeException{
    public EmployeesNotFoundIdException(String message) {
        super(message);
    }
}
