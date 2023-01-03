package com.example.dao;

import com.example.exception.EmployeeDaoException;
import com.example.model.Employee;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

    private static final String EMPLOYEE_FILE = "employees.txt";
    private static final String DELIMITER = "::";

    private Map<Integer,Employee> employees = new HashMap<>();
    private int count = 0;

    @Override
    public List<Employee> getAllEmployees() {
        try {
            loadEmployees();
        } catch (EmployeeDaoException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(employees.values());
    }

    @Override
    public Employee getEmployeeById(int id) {
        try {
            loadEmployees();
        } catch (EmployeeDaoException e) {
            e.printStackTrace();
        }
        return employees.get(id);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        count++;
        try {
            loadEmployees();
            employee.setId(count);
            employees.put(count, employee);
            writeEmployee();
            return employee;
        } catch (EmployeeDaoException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try {
            loadEmployees();
            Employee origin = employees.get(employee.getId());
            if (origin != null) {
                origin.setFirstName(employee.getFirstName());
                origin.setLastName(employee.getLastName());
                origin.setEmail(employee.getEmail());
                origin.setMonthlySalary(employee.getMonthlySalary());
            }
            writeEmployee();
        } catch (EmployeeDaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(int id) {
        try {
            loadEmployees();
            employees.remove(id);
            writeEmployee();
        } catch (EmployeeDaoException e) {
            e.printStackTrace();
        }
    }

    private void loadEmployees() throws EmployeeDaoException {
        Scanner scanner = null;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(EMPLOYEE_FILE)));
            String currentLine;
            Employee currentEmployee;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentEmployee = unmarshalEmployee(currentLine);
                employees.put(currentEmployee.getId(), currentEmployee);
            }

            count = getNextCount(employees);
        } catch (FileNotFoundException e) {
            throw new EmployeeDaoException("Could not load employee data into memory.", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private void writeEmployee() throws EmployeeDaoException {
        PrintWriter out = null;

        try {
            out = new PrintWriter(new FileWriter(EMPLOYEE_FILE));
            String employeeText;
            List<Employee> employeeList = new ArrayList<>(employees.values());
            for (Employee employee : employeeList) {
                employeeText = marshalEmployee(employee);
                out.println(employeeText);
                out.flush();
            }
        } catch (IOException e) {
            throw new EmployeeDaoException("Could not save employee data.", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * Unmarshal Employee.
     * @param employeeAsText employeeAsText is expecting a line read in from employees.txt
     *                       For example, it might look like this:
     *                       1234:Leo::Sun::lsun@example::2000
     * @return
     */
    private Employee unmarshalEmployee(String employeeAsText) {
        String[] employeeTokens = employeeAsText.split(DELIMITER);
        Employee employee = new Employee();

        employee.setId(Integer.parseInt(employeeTokens[0]));
        employee.setFirstName(employeeTokens[1]);
        employee.setLastName(employeeTokens[2]);
        employee.setEmail(employeeTokens[3]);
        employee.setMonthlySalary(new BigDecimal(employeeTokens[4]));
        return employee;
    }

    /**
     * Marshal Employee.
     * @param employee
     * @return A string representation of employee in form of
     *          1234:Leo::Sun::lsun@example::2000
     */
    private String marshalEmployee(Employee employee) {
        String employeeText = employee.getId() + DELIMITER;
        employeeText += employee.getFirstName() + DELIMITER;
        employeeText += employee.getLastName() + DELIMITER;
        employeeText += employee.getEmail() + DELIMITER;
        employeeText += employee.getMonthlySalary();
        return employeeText;
    }

    /**
     * Get the next count which is used to set next employee's id.
     * @param employees
     * @return
     */
    private int getNextCount(Map<Integer, Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return 1;
        }

        Integer maxEmployeeId = Collections.max(employees.keySet());
        return ++maxEmployeeId;
    }
}
