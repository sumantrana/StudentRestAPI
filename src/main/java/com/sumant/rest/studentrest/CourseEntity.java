package com.sumant.rest.studentrest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Course")
public class CourseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    public static Course fromEntity(CourseEntity courseEntity){
        return Course.builder()
                .id(courseEntity.getId())
                .name(courseEntity.getName())
                .build();
    }
}
