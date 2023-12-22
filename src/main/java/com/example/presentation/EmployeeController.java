package com.example.presentation;

import com.example.domain.Employee;
import com.example.domain.EmployeeAll;
import com.example.infrastructure.EmployeesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO javadoc
@RestController
@RequestMapping("/v1/employees")
public class EmployeeController {
    @GetMapping
    public EmployeeAll findAll() {
        List<Employee> employees = List.of(
                new Employee("1", "Taro", "Yamada"),
                new Employee("2", "Jiro", "Yamada")
        );
        return new EmployeeAll(employees);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id) {
        List<Employee> employees = List.of(
                new Employee("1", "Taro", "Yamada"),
                new Employee("2", "Jiro", "Yamada")
        );
        Employee responseEmployee = null;
        for (Employee employee : employees) {
            if (id.equals(employee.id())) responseEmployee = employee;
        }
        return responseEmployee;
    }

    @PatchMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable String id, @RequestBody Employee employee) {
        String firstName = employee.firstName();
        String lastName = employee.lastName();

        //TODO DataBase

        System.out.println(firstName);
        System.out.println(lastName);
    }
}
