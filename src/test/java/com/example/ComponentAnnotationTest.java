package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.Annotation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import com.example.controller.EmployeeController;
import com.example.dao.EmployeeDaoImpl;
import com.example.view.EmployeeView;
import com.example.view.UserIOConsoleImpl;

/**
 * This test is used to check if @Component is existed on beans managed by spring context.
 */
public class ComponentAnnotationTest {
    
    @Test
    @DisplayName("Test if @Component exists on EmployeeController")
    public void testComponentAnnotationExistOnController() {

        Annotation annotation = EmployeeController.class.getAnnotation(Component.class);
        assertTrue(annotation != null);
    }

    @Test
    @DisplayName("Test if @Component exists on EmployeeDaoImpl")
    public void testComponentAnnotationExistOnEmployeeDaoImpl() {

        Annotation annotation = EmployeeDaoImpl.class.getAnnotation(Component.class);
        assertTrue(annotation != null);
    }

    @Test
    @DisplayName("Test if @Component exists on EmployeeView")
    public void testComponentAnnotationExistOnEmployeeView() {

        Annotation annotation = EmployeeView.class.getAnnotation(Component.class);
        assertTrue(annotation != null);
    }

    @Test
    @DisplayName("Test if @Component exists on UserIOConsoleImpl")
    public void testComponentAnnotationExistOnUserIOConsoleImpl() {
        Annotation annotation = UserIOConsoleImpl.class.getAnnotation(Component.class);
        assertTrue(annotation != null);
    }
}
