package com.example.domain;

import com.example.usecase.Employees;

import java.util.List;

public record EmployeeAll(List<Employees> employees) {
}
