package com.klef.jfsd.springboot.services;

import com.klef.jfsd.springboot.model.Course;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> displayAllCourses();
    Course displayCourse(Long id);
    Course updateCourse(Long id, Course course);
}