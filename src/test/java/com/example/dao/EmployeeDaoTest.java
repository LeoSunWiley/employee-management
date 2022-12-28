package com.example.dao;

import com.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeDaoTest {

    private final EmployeeDao employeeDao;

    public EmployeeDaoTest() {
        this.employeeDao = new EmployeeDaoImpl();
    }

    @BeforeEach
    public void setUp() {
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }
    }

    @Test
    public void testAddGetEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee.setEmail("test@example.com");
        employee.setMonthlySalary(new BigDecimal("2000"));
        employee = employeeDao.addEmployee(employee);

        Employee fromDao = employeeDao.getEmployeeById(employee.getId());
        assertEquals(employee, fromDao);
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee.setEmail("test@example.com");
        employee.setMonthlySalary(new BigDecimal("2000"));
        employee = employeeDao.addEmployee(employee);

        Employee employee2 = new Employee();
        employee2.setFirstName("Test First 2");
        employee2.setLastName("Test Last 2");
        employee2.setEmail("test2@example.com");
        employee2.setMonthlySalary(new BigDecimal("3000"));
        employee2 = employeeDao.addEmployee(employee2);

        List<Employee> employees = employeeDao.getAllEmployees();

        assertEquals(2, employees.size());
        assertTrue(employees.contains(employee));
        assertTrue(employees.contains(employee2));
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee.setEmail("test@example.com");
        employee.setMonthlySalary(new BigDecimal("2000"));
        employee = employeeDao.addEmployee(employee);

        Employee fromDao = employeeDao.getEmployeeById(employee.getId());

        assertEquals(employee, fromDao);

        employee.setFirstName("Another Test First");

        employeeDao.updateEmployee(employee);

        assertNotEquals(employee, fromDao);

        fromDao = employeeDao.getEmployeeById(employee.getId());

        assertEquals(employee, fromDao);
    }

    @Test
    void testDeleteEmployeeById() {
        Employee employee = new Employee();
        employee.setFirstName("Test First");
        employee.setLastName("Test Last");
        employee.setEmail("test@example.com");
        employee.setMonthlySalary(new BigDecimal("2000"));
        employee = employeeDao.addEmployee(employee);

        employeeDao.deleteEmployeeById(employee.getId());

        Employee fromDao = employeeDao.getEmployeeById(employee.getId());

        assertNull(fromDao);
    }
}
