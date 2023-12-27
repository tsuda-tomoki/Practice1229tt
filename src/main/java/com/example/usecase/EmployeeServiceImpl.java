package com.example.usecase;

import com.example.domain.RequestEmployee;
import com.example.infrastructure.EmployeesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeesMapper employeesMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Employees> findAll() {
        return employeesMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employees findById(String id) {
        return employeesMapper.findById(id);
    }

    @Override
    @Transactional
    public void insert(RequestEmployee requestEmployee) {
       employeesMapper.insert(requestEmployee);
    }

    @Override
    @Transactional
    public void delete(String id) {
        employeesMapper.delete(id);
    }
}
