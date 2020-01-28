package com.denys.springcontextinitsteps.applicationContextInitializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * works when context is setted.
 * you should create class with EnvironmentPostProcessor interface and write full name of this class
 * in resources -> META-INF -> spring.factories file
 */
public class MyApplicationInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        System.out.println("=================>>>  MyApplicationInitializer");
    }
}
