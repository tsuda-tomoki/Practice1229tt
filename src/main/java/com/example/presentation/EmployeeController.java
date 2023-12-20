package com.example.presentation;

import com.example.domain.Employee;
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
    public List<Employee> findAll() {
        return List.of(
                new Employee("101", "Akiko", "Yosano"),
                new Employee("102", "Kazuma", "Kiryu")
        );
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable String id) {
        List<Employee> employeeList = List.of(
                new Employee("101", "Akiko", "Yosano"),
                new Employee("102", "Kazuma", "Kiryu")

        );
        Employee responseEmployee = null;
        for (Employee employee : employeeList) {
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
