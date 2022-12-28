package com.example.controller;

import java.util.List;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;
import com.example.view.EmployeeView;

public class EmployeeController {
    
    private final EmployeeView view;
    private final EmployeeDao employeeDao;

    /**
     * Employee controller is the center of employee management.
     * Employee controller does 4 things:
     * 1) Accept user's input through io from EmployeeView.
     * 2) Handle each operation
     * 3) Delegate to EmployeeDao to manage CRUD operations for employees.
     * 4) Delegate to EmployeeView to display operation results.
     * @param view
     */
    public EmployeeController(
            EmployeeView view,
            EmployeeDao employeeDao) {
        this.view = view;
        this.employeeDao = employeeDao;
    }

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
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6:
                    break;
            }

            System.out.println();
        }
    }

    private void listEmployees() {
        view.listEmployeesBanner();
        List<Employee> employees = employeeDao.getAllEmployees();
        view.displayEmployees(employees);
    }

    private void addEmployee() {
        view.addEmployeeBanner();
    }
}
