package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDao {
    
    List<Employee> getAllEmployees();

    Employee getEmployeeById(int id);

    Employee addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}
