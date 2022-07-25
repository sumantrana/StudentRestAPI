package com.sumant.rest.studentrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * Use Hibernate ddl-auto
 * By default, @DataJpaTest will configure Hibernate to automatically create the database
 * schema for us. The attribute responsible for this is spring.jpa.hibernate.ddl-auto ,
 * and Spring Boot sets it to create-drop default, which means that the pattern is created
 * before running the test and deleted after the test is executed.
 * Therefore, if we are satisfied that Hibernate creates the pattern for us, we don't have to
 * do anything.
 */

/**
 * Use schema.sql
 * Spring Boot supports executing custom schema.sql files when the application starts.
 * If Spring finds the schema.sql file in the classpath, it will be executed against the data
 * source. This will override Hibernate's ddl-auto configuration discussed above.
 * We can use the attribute spring.datasource.initialization-mode schema.sql should be
 * executed. The default value is embedded, which means it will only be executed against the
 * embedded database (ie in our tests). If we set it to always , it will always execute.
 */

/**
 * Use Flyway
 * Flyway is a database migration tool that allows you to specify multiple SQL scripts to
 * create database schemas. It keeps track of which of these scripts have been executed on
 * the target database so that only scripts that have not been executed before are executed.
 * To activate Flyway, we just need to put the dependencies into our build.gradle file
 *
 * If we do not specifically configure Hibernate's ddl-auto configuration, it will
 * automatically exit, so Flyway has priority, and by default it will execute all the SQL
 * scripts it finds src/main/resources/db/migration
 * Similarly, it makes sense to set ddl-auto to validate let Hibernate check whether the
 * pattern generated by Flyway meets the expectations of our Hibernate entity:
 */

/**
 * Populate the database
 * Now that we have created a database schema for our test, we can finally start the actual
 * test. In database query testing, we usually add some data to the database and then verify
 * that our query returns the correct results.
 * Similarly, there are multiple ways to add data to our in-memory database, so let's discuss
 * them one by one.
 */

@DataJpaTest
@Sql("/course-data.sql")
public class CourseRepositoryTests {

    @Autowired
    CourseJPARepository courseJpaRepository;

    @Test
    public void findAllCourses_WillReturn_AllCourses(){
        List<CourseEntity> courseEntityList = courseJpaRepository.findAll();
        assertThat(courseEntityList, hasSize(4));
    }
}
