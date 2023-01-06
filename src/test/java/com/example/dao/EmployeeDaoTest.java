package com.example.dao;

import com.example.config.ProjectConfig;
import com.example.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ProjectConfig.class)
public class EmployeeDaoTest {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeDaoTest(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @BeforeEach
    public void setUp() {
        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }
    }

    @Test
    @DisplayName("Test case - Add and get a employee")
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
    @DisplayName("Test case - Get all employees")
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
    @DisplayName("Test case - Update a employee")
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
    @DisplayName("Test case - Delete a employee")
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
