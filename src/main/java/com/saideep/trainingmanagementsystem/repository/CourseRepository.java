package com.saideep.trainingmanagementsystem.repository;

import com.saideep.trainingmanagementsystem.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CourseRepository extends JpaRepository<Course,Long> {

}
