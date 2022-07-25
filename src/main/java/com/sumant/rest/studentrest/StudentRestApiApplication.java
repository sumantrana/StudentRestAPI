package com.sumant.rest.studentrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is a convenience annotation that adds all of the following:
 *
 * @Configuration: Tags the class as a source of bean definitions for the application context.
 *
 * @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath
 * settings, other beans, and various property settings.
 *
 * @EnableWebMvc: Flags the application as a web application and activates key behaviors,
 * such as setting up a DispatcherServlet. Spring Boot adds it automatically when it sees
 * spring-webmvc on the classpath.
 *
 * @ComponentScan: Tells Spring to look for other components, configurations, and services
 * in the the com.example.testingweb package, letting it find the HelloController class.
 */
@SpringBootApplication
public class StudentRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentRestApiApplication.class, args);
    }

}
