package com.example.usecase;

import com.example.domain.RequestEmployee;
import com.example.domain.UpdateEmployee;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees findById(String id);
    void insert(RequestEmployee requestEmployee);
    void delete(String id);
    void update(String id, UpdateEmployee updateEmployee);
}
