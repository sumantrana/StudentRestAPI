package com.sumant.rest.studentrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * The @SpringBootTest annotation tells Spring Boot to look for a main configuration class
 * (one with @SpringBootApplication, for instance) and use that to start a Spring application
 * context.
 */

/**
 * A nice feature of the Spring Test support is that the application context is cached between
 * tests. That way, if you have multiple methods in a test case or multiple test cases with
 * the same configuration, they incur the cost of starting the application only once. You can
 * control the cache by using the @DirtiesContext annotation.
 */
@SpringBootTest
class StudentRestApiApplicationTests {

    @Autowired
    CourseController courseController;

    @Test
    void contextLoads() {
        assertThat(courseController).isNotNull();
    }

}
