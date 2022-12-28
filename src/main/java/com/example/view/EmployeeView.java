package com.example.view;

import com.example.model.Employee;

import java.math.BigDecimal;
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

    public void displayEmployee(Employee employee) {
        String builder = employee.getId() +
                " -- " +
                employee.getFirstName() + " " + employee.getLastName() +
                " -- " +
                employee.getEmail() +
                " -- " +
                employee.getMonthlySalary();
        io.print(builder);
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

    public void invalidEmployee() {
        io.print("No Employee with that ID");
    }

    public void addEmployeeBanner() {
        io.print("Adding Employee");
        io.print("");
    }

    public int getEmployeeId() {
        return io.readInt("Enter employee id: ");
    }

    public String getEmployeeFirstName() {
        return io.readString("Enter employee first name: ");
    }

    public String getEmployeeLastName() {
        return io.readString("Enter employee last name: ");
    }

    public String getEmployeeEmail() {
        return io.readString("Enter employee email: ");
    }

    public BigDecimal getEmployeeSalary() {
        return io.readBigDecimal("Enter employee salary: ");
    }

    public void addEmployeeSuccess() {
        io.print("Employee added successfully");
    }

    public void retrieveEmployeeBanner() {
        io.print("Retrieving Employee");
        io.print("");
    }

    public void updateEmployeeBanner() {
        io.print("Updating Employee");
    }

    public void displayUpdateInstructions() {
        io.print("Hit enter to keep original value.");
    }

    public String updateField(String fieldName, String original) {
        String update = io.readString("Update " + fieldName + " (" + original + ") ");
        if (update.trim().isEmpty()) {
            return original;
        }
        return update;
    }

    public BigDecimal updateField(String fieldName, BigDecimal original) {
        String update = io.readString("Update " + fieldName + " (" + original + ") ");
        if (update.trim().isEmpty()) {
            return original;
        }
        return BigDecimal.valueOf(Double.valueOf(update));
    }

    public void updateEmployeeSuccess() {
        io.print("Employee updated successfully.");
    }

    public void deleteEmployeeBanner() {
        io.print("Deleting Employee");
    }

    public void deleteEmployeeSuccess() {
        System.out.println("Employee deleted successfully.");
    }

    public void exit() {
        io.print("Existing Meeting Manager");
    }

}
