package com.example.presentation;

import com.example.domain.Employee;
import com.example.domain.EmployeeAll;
import com.example.domain.RequestEmployee;
import com.example.usecase.EmployeeService;
import com.example.usecase.Employees;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public Employees findById(@PathVariable String id) {
        return employeeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RequestEmployee> insert(@RequestBody @Validated RequestEmployee requestEmployee) {
        employeeService.insert(requestEmployee);

        URI location =
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .pathSegment(requestEmployee.getId())
                .build().encode().toUri();
        return ResponseEntity.created(location).build();
    }
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
