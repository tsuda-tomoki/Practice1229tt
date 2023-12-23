package com.example.presentation;

import com.example.domain.Employee;
import com.example.domain.EmployeeAll;
import com.example.usecase.EmployeeService;
import com.example.usecase.Employees;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO javadoc
@RestController
@AllArgsConstructor
@RequestMapping("/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public EmployeeAll findAll() {
        List<Employees> employeesList = employeeService.findAll();

        return new EmployeeAll(employeesList);
    }

//    @GetMapping("/{id}")
//    public Employee findById(@PathVariable String id) {
//        List<Employee> employees = List.of(
//                new Employee("1", "Taro", "Yamada"),
//                new Employee("2", "Jiro", "Yamada")
//        );
//        Employee responseEmployee = null;
//        for (Employee employee : employees) {
//            if (id.equals(employee.id())) responseEmployee = employee;
//        }
//        return responseEmployee;
//    }
//
//    @PatchMapping("/id")
//    @ResponseStatus(HttpStatus.OK)
//    public void update(@PathVariable String id, @RequestBody Employee employee) {
//        String firstName = employee.firstName();
//        String lastName = employee.lastName();
//
//        //TODO DataBase
//
//        System.out.println(firstName);
//        System.out.println(lastName);
//    }
}
