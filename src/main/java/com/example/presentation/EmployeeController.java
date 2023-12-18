package com.example.presentation;

import com.example.domain.RequestEmployee;
import com.example.domain.ResponseEmployee;
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
    public List<ResponseEmployee> findAll() {
        return List.of(
                new ResponseEmployee(101, "Akiko", "Yosano"),
                new ResponseEmployee(102, "Kazuma", "Kiryu")
        );
    }

    @GetMapping("/{id}")
    public ResponseEmployee findById(@PathVariable Integer id) {
        List<ResponseEmployee> responseEmployeeList = List.of(
                new ResponseEmployee(101, "Akiko", "Yosano"),
                new ResponseEmployee(102, "Kazuma", "Kiryu")

        );
        ResponseEmployee responseEmployeeResponse = null;
        for (ResponseEmployee responseEmployee : responseEmployeeList) {
            if (id.equals(responseEmployee.id())) responseEmployeeResponse = responseEmployee;
        }
        return responseEmployeeResponse;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Integer id, @RequestBody RequestEmployee requestEmployee) {
        String firstName = requestEmployee.getFirstName();
        String lastName = requestEmployee.getLastName();

        //TODO DataBase

        System.out.println(firstName);
        System.out.println(lastName);
    }
}
