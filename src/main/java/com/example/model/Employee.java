package com.example.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private BigDecimal monthlySalary;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(BigDecimal monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                email.equals(employee.email) &&
                monthlySalary.equals(employee.monthlySalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, monthlySalary);
    }
}
