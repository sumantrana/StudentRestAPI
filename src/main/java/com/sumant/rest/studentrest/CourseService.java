package com.sumant.rest.studentrest;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private CourseJPARepository courseJPARepository;

    public CourseService(CourseJPARepository courseJPARepository){
        this.courseJPARepository = courseJPARepository;
    }
    public List<Course> getCourses(){
        return courseJPARepository.findAll()
                .stream()
                .map(CourseEntity::fromEntity)
                .collect(Collectors.toList());
    }
}
