package com.denys.springcontextinitsteps.environmentPostProcessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * works when setting context.
 * you should create class with EnvironmentPostProcessor interface and write full name of this class
 * in resources -> META-INF -> spring.factories file
 */
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        System.out.println("==========================>>>  MyEnvironmentPostProcessor");
    }
}
