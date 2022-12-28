package com.example.dao;

import com.example.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private List<Employee> employees = new ArrayList<>();
    private int count = 0;

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        // calculate a employee id.
        // each a new employee added to employees. 
        // count field is incremented.
        count++;
        employee.setId(count);
        employees.add(employee);
        return employee;
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee origin = getEmployeeById(employee.getId());
        if (origin != null) {
            origin.setFirstName(employee.getFirstName());
            origin.setLastName(employee.getLastName());
            origin.setEmail(employee.getEmail());
            origin.setMonthlySalary(employee.getMonthlySalary());
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employees.remove(employee);
        }
    }
}
