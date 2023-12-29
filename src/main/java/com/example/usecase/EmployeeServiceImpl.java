package com.example.usecase;

import com.example.Exception.EmployeesNotFoundException;
import com.example.domain.RequestEmployee;
import com.example.domain.UpdateEmployee;
import com.example.infrastructure.EmployeesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        if (employeesMapper.findById(id) == null) {
            throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
        }
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
        int count = employeesMapper.delete(id);
        if (count == 0) {
            throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
        }
        employeesMapper.delete(id);
    }

    @Override
    @Transactional
    public void update(String id, UpdateEmployee updateEmployee) {
        int count = employeesMapper.update(id, updateEmployee);
        if (count == 0) {
            throw new EmployeesNotFoundException("specified employee [id = " + id + "] is not found.");
        }
        employeesMapper.update(id, updateEmployee);
    }
}
