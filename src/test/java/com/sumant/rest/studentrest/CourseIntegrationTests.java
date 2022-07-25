package com.sumant.rest.studentrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * Note the use of webEnvironment=RANDOM_PORT to start the server with a random port
 * (useful to avoid conflicts in test environments) and the injection of the port with
 * @LocalServerPort. Also, note that Spring Boot has automatically provided a TestRestTemplate
 * for you. All you have to do is add @Autowired to it.
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("/course-data.sql")
public class CourseIntegrationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @LocalServerPort
    int port;

    @Test
    public void getAllCourses_WillReturn_AllCourses(){

        String baseURI = "http://localhost:" + port;
        List<Course> courseList = List.of(Objects.requireNonNull(testRestTemplate.getForEntity(baseURI + "/courses", Course[].class).getBody()));

        assertThat(courseList, hasSize(4));
    }
}
