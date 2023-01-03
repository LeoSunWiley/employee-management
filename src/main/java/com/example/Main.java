package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.ProjectConfig;
import com.example.controller.EmployeeController;

public class Main {
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        EmployeeController employeeController = context.getBean(EmployeeController.class);
        
        employeeController.run();
        ((ConfigurableApplicationContext) context).close();
    }
}
