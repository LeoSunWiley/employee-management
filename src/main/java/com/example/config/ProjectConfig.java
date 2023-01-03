package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.example.controller",
        "com.example.dao",
        "com.example.view" })
public class ProjectConfig {

}
