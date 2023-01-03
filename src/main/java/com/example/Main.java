package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.controller.EmployeeController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:employee-management-context.xml");
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        
        employeeController.run();
        ((ConfigurableApplicationContext) context).close();
    }
}
