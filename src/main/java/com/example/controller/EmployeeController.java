package com.example.controller;

import java.math.BigDecimal;
import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;
import com.example.model.Employee;
import com.example.view.EmployeeView;
import com.example.view.UserIO;
import com.example.view.UserIOConsoleImpl;

/**
 * EmployeeController is in the center of employee management.
 * Employee controller does 4 things:
 * 1) Accept user's input choice.
 * 2) Handle each operation
 * 3) Delegate to EmployeeDao to execute CRUD operations for employees.
 * 4) Delegate to EmployeeView to display operation results.
 */
public class EmployeeController {

    private final EmployeeView view;
    private final EmployeeDao employeeDao;

    /**
     * 
     * @param view
     * @param employeeDao
     */
    public EmployeeController() {
        UserIO io = new UserIOConsoleImpl();
        this.view = new EmployeeView(io);
        this.employeeDao = new EmployeeDaoImpl();
    }

    /**
     * Controls
     */
    public void run() {

        while (true) {
            view.displayProgramBanner();
            view.displayMenu();

            int choice = view.getMenuChoice(6);

            switch (choice) {
                case 1:
                    listEmployees(); // List all employees
                    break;
                case 2:
                    addEmployee(); // Add Employee
                    break;
                case 3:
                    retrieveEmployee(); // Retrieve Employee
                    break;
                case 4:
                    updateEmployee(); // Update Employee
                    break;
                case 5:
                    deleteEmployee(); // Delete Employee
                    break;
                case 6: // Exit
                    view.exit();
                    System.exit(0);
            }
        }
    }

    private void listEmployees() {
        view.listEmployeesBanner();
        List<Employee> employees = employeeDao.getAllEmployees();
        view.displayEmployees(employees);
    }

    private void addEmployee() {
        view.addEmployeeBanner();

        String firstName = view.getEmployeeFirstName();
        String lastName = view.getEmployeeLastName();
        String email = view.getEmployeeEmail();
        BigDecimal salary = view.getEmployeeSalary();

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setMonthlySalary(salary);

        employeeDao.addEmployee(employee);

        view.addEmployeeSuccess();
    }

    private void retrieveEmployee() {
        view.retrieveEmployeeBanner();
        int id = view.getEmployeeId();
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee != null) {
            view.displayEmployee(employee);
        } else {
            view.invalidEmployee();
        }
    }

    private void updateEmployee() {
        view.updateEmployeeBanner();
        int id = view.getEmployeeId();
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee != null) {
            view.displayUpdateInstructions();
            String firstName = view.updateField("First Name", employee.getFirstName());
            String lastName = view.updateField("Last Name", employee.getLastName());
            String email = view.updateField("Email", employee.getEmail());
            BigDecimal salary = view.updateField("Monthly Salary", employee.getMonthlySalary());

            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setEmail(email);
            employee.setMonthlySalary(salary);

            employeeDao.updateEmployee(employee);
            view.updateEmployeeSuccess();
        } else {
            view.invalidEmployee();
        }
    }

    private void deleteEmployee() {
        view.deleteEmployeeBanner();
        int id = view.getEmployeeId();
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee != null) {
            employeeDao.deleteEmployeeById(id);
            view.deleteEmployeeSuccess();
        } else {
            view.invalidEmployee();
        }
    }
}
