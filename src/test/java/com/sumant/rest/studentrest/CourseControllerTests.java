package com.sumant.rest.studentrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Another useful approach is to not start the server at all but to test only the layer below
 * that, where Spring handles the incoming HTTP request and hands it off to your controller.
 * That way, almost of the full stack is used, and your code will be called in exactly the same
 * way as if it were processing a real HTTP request but without the cost of starting the server.
 * To do that, use Spring’s MockMvc and ask for that to be injected for you by using the
 * @AutoConfigureMockMvc annotation on the test case.
 *
 * @SpringBootTest
 * @AutoConfigureMockMvc
 *
 *        @Autowired
 *    private MockMvc mockMvc;
 */

@WebMvcTest
public class CourseControllerTests {

    MockMvc mockMvc;

    @MockBean
    CourseService courseService;

    @BeforeEach
    public void setup(){
        CourseController courseController = new CourseController(courseService);
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }


    @Test
    public void testGetCourses_WillReturn_200OK() throws Exception {

        mockMvc.perform(get("/courses"))
                    .andExpect(status().isOk());
    }

    @Test
    public void testGetCourses_WillReturn_AList() throws Exception {

        Course course = Course.builder().id(1).name("English").build();
        given(courseService.getCourses()).willReturn(List.of(course));

        mockMvc.perform(get("/courses").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("English"))
                .andExpect(jsonPath("$[0].id").value("1"));

        Mockito.verify(courseService, times(1)).getCourses();
    }

}
