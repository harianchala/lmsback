package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.services.FacultyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adjust origin as per your frontend host
@RequestMapping("/api/faculty")
public class FacultyController {
	@Autowired
	private FacultyService facultyService;

    @PostMapping("/create")
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/all")
    public List<Faculty> getAllFaculty() {
        return facultyService.getAllFacultys();
    }

    @GetMapping("/all/{id}")	
    public Faculty getFacultyById(@PathVariable Long id) {
        return facultyService.getFacultyById(id);
    }

    @PutMapping("/update/{id}")
    public String updateFaculty(@PathVariable Long id, @RequestBody Faculty faculty) {
        return facultyService.updateFaculty(id, faculty);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        return facultyService.deleteFaculty(id);
    }
}
