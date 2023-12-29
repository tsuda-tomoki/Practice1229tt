package com.example.presentation;

import com.example.Exception.EmployeesNotFoundException;
import com.example.Exception.EmployeesNotFoundIdException;
import com.example.domain.Details;
import com.example.domain.EmployeeAll;
import com.example.domain.ExceptionHandResponse;
import com.example.domain.RequestEmployee;
import com.example.domain.UpdateEmployee;
import com.example.usecase.EmployeeService;
import com.example.usecase.Employees;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

// TODO javadoc
@RestController
@AllArgsConstructor
@RequestMapping("/v1/employees")
@ResponseStatus(HttpStatus.OK)
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

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable String id, @RequestBody @Validated UpdateEmployee updateEmployee) {
        employeeService.update(id, updateEmployee);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandResponse handleError(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<Details> detailsList = List.of(new Details("firstName must not be blank"));
        return new ExceptionHandResponse("0002", "request validation error is occurred.", detailsList);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionHandResponse handleEmployeeNotFound(EmployeesNotFoundException e) {
        String message = e.getMessage();
        return new ExceptionHandResponse("0003", message, Collections.emptyList());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionHandResponse handleEmployeeIdNotFound(EmployeesNotFoundIdException e) {
        String message = e.getMessage();
        return new ExceptionHandResponse("0001", message, Collections.emptyList());
    }

}
