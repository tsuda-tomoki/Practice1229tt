package com.example.usecase;

import com.example.domain.RequestEmployee;
import com.example.usecase.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees findById(String id);
    void insert(RequestEmployee requestEmployee);
}
