package com.example.infrastructure;

import com.example.usecase.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeesMapper {
    @Select("SELECT id, first_name, last_name FROM employees")
    List<Employees> findAll();

    @Select("SELECT id, first_name, last_name FROM employees WHERE id = #{id}")
    Employees findById(String id);
}
