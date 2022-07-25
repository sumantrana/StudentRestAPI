package com.sumant.rest.studentrest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJPARepository extends JpaRepository<CourseEntity, Integer> {


}
