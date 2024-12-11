package com.klef.jfsd.springboot.repository;

import com.klef.jfsd.springboot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}