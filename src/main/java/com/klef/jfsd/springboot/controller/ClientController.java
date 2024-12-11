package com.klef.jfsd.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.services.UserService;

@RestController
@RequestMapping("/lms1")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController 
{
	@Autowired
    private UserService userService;

    @PostMapping("login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Determine user type based on username length
        int usernameLength = username.length();
        String userType;

        if (usernameLength == 10) {
            userType = "student";
        } else if (usernameLength == 4) {
            userType = "faculty";
        } else if (usernameLength == 3) {
            userType = "admin";
        } else {
            return "Invalid credentials"; // Invalid username length
        }

        // Check username and password in the respective table
        switch (userType) {
            case "student":
                Optional<Student> student = userService.findStudentByUsername(username);
                if (student.isPresent() && student.get().getPassword().equals(password)) {
                    return "student";
                }
                break;

            case "faculty":
                Optional<Faculty> faculty = userService.findFacultyByUsername(username);
                if (faculty.isPresent() && faculty.get().getPassword().equals(password)) {
                    return "faculty";
                }
                break;

            case "admin":
                Optional<Admin> admin = userService.findAdminByUsername(username);
                if (admin.isPresent() && admin.get().getPassword().equals(password)) {
                    return "admin";
                }
                break;
        }

        // If no match is found
        return "Invalid credentials";
    }
}
