package com.example;

import com.example.usecase.EmployeeService;
import com.example.usecase.Employees;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class StartupApplication {

    public static void main(String[] args) {
      ApplicationContext context = SpringApplication.run(StartupApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        List<Employees> employeesList = employeeService.findAll();
        for (Employees employees : employeesList) {
            System.out.println(employees.getFirstName());
            System.out.println(employees.getLastName());

        }
    }
}
