package com.sumant.rest.studentrest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

public class CourseServiceTests {

    @Mock
    CourseJPARepository courseJPARepository;

    CourseService courseService;

    @BeforeEach
    public void setup(){
        openMocks(this);
        courseService = new CourseService(courseJPARepository);
    }

    @Test
    public void getCourses_WillReturn_Courses(){

        CourseEntity courseEntity = CourseEntity.builder().id(1).name("English").build();
        given(courseJPARepository.findAll()).willReturn(List.of(courseEntity));

        List<Course> courseList = courseService.getCourses();

        assertThat(courseList).hasSize(1);
        verify(courseJPARepository, times(1)).findAll();

    }
}
