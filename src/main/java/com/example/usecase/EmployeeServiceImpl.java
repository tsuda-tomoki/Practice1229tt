package com.example.usecase;

import com.example.infrastructure.EmployeesMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeesMapper employeesMapper;

    public EmployeeServiceImpl(EmployeesMapper employeesMapper) {
        this.employeesMapper = employeesMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employees> findAll() {
        return employeesMapper.findAll();
    }
}
