package com.example.view;

import com.example.model.Employee;

import java.util.List;

public class EmployeeView {
    
    private final UserIO io;

    public EmployeeView(UserIO io) {
        this.io = io;
    }

    public void printError(Exception ex) {
        io.print("ERROR: " + ex.getMessage());
        ex.printStackTrace();
    }

    public void displayProgramBanner() {
        io.print("Employee Manager");
        io.print("");
    }

    public void displayMenu() {
        io.print("1. List Employees");
        io.print("2. Add Employee");
        io.print("3. Retrieve Employee");
        io.print("4. Update Employee");
        io.print("5. Delete Employee");
        io.print("6. Exit");
        io.print("");
    }

    public int getMenuChoice(int maxChoice) {
        return io.readInt("Enter menu selection", 1, maxChoice);
    }

    public void listEmployeesBanner() {
        io.print("All Employees");
        io.print("");
    }

    public void displayEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            String builder = employee.getId() +
                    " -- " +
                    employee.getFirstName() + " " + employee.getLastName() +
                    " -- " +
                    employee.getEmail() +
                    " -- " +
                    employee.getMonthlySalary();
            io.print(builder);
        }
        io.print("");
    }

    public void addEmployeeBanner()

}
