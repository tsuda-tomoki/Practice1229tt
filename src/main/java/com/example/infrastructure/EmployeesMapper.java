package com.example.infrastructure;

import com.example.domain.RequestEmployee;
import com.example.domain.UpdateEmployee;
import com.example.usecase.Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmployeesMapper {
    @Select("SELECT id, first_name, last_name FROM employees")
    List<Employees> findAll();

    @Select("SELECT id, first_name, last_name FROM employees WHERE id = #{id}")
    Employees findById(String id);

    @Insert("INSERT INTO employees (id, first_name, last_name) VALUES (nextval('EMPLOYEE_ID_SEQ'), #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insert(RequestEmployee requestEmployee);

    @Delete("DELETE FROM employees WHERE id = #{id}")
     int delete(String id);

    @Update("UPDATE employees SET first_name = #{updateEmployee.firstName}, last_name = #{updateEmployee.lastName} WHERE id = #{id}")
    int update(@Param("id") String id, @Param("updateEmployee")UpdateEmployee updateEmployee);}
