package com.klef.jfsd.springboot.services;

import com.klef.jfsd.springboot.model.Course;
import com.klef.jfsd.springboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> displayAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course displayCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            return course.get();
        } else {
            throw new RuntimeException("Course not found with ID: " + id);
        }
    }

    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
        Course course = displayCourse(id); // Fetch existing course or throw error
        course.setCourseId(updatedCourse.getCourseId());
        course.setTitle(updatedCourse.getTitle());
        course.setDescription(updatedCourse.getDescription());
        course.setTopicsCovered(updatedCourse.getTopicsCovered());
        course.setDuration(updatedCourse.getDuration());
        course.setLevel(updatedCourse.getLevel());
        course.setLanguage(updatedCourse.getLanguage());
        course.setStartDate(updatedCourse.getStartDate());
        course.setEndDate(updatedCourse.getEndDate());
        return courseRepository.save(course);
    }
}