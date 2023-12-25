package com.example.infrastructure;

import com.example.domain.RequestEmployee;
import com.example.usecase.Employees;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeesMapper {
    @Select("SELECT id, first_name, last_name FROM employees")
    List<Employees> findAll();

    @Select("SELECT id, first_name, last_name FROM employees WHERE id = #{id}")
    Employees findById(String id);

    @Insert("INSERT INTO employees (id, first_name, last_name) VALUES (nextval('EMPLOYEE_ID_SEQ'), #{firstName}, #{lastName})")
    void insert(RequestEmployee requestEmployee);
}
