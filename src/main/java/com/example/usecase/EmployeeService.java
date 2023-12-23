package com.example.usecase;

import com.example.usecase.Employees;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees findById(String id);
}
