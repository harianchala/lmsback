package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Course;
import com.klef.jfsd.springboot.services.CourseService;

@RestController
@CrossOrigin(origins = "*") // Adjust origin as per your frontend host
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	  @PostMapping("/create")
	    public Course createCourse(@RequestBody Course course) {
	        return courseService.createCourse(course);
	    }
	  
	  @GetMapping("/all")
	    public List<Course> displayAllCourses() {
	        return courseService.displayAllCourses();
	    }
	  

	    @GetMapping("/all/{id}")
	    public Course displayCourse(@PathVariable Long id) {
	        return courseService.displayCourse(id);
	    }
	    
	    @PutMapping("/update/{id}")
	    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
	        return courseService.updateCourse(id, course);
	    }

}
