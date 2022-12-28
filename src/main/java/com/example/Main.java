package com.example;

import com.example.controller.EmployeeController;
import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;
import com.example.view.EmployeeView;
import com.example.view.UserIO;
import com.example.view.UserIOConsoleImpl;

public class Main {
    
    public static void main(String[] args) {

        UserIO io = new UserIOConsoleImpl();
        EmployeeView employeeView = new EmployeeView(io);

        EmployeeDao employeeDao = new EmployeeDaoImpl();
        EmployeeController employeeController = new EmployeeController(employeeView, employeeDao);
        employeeController.run();
    }
}
