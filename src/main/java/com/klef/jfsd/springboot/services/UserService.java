package com.klef.jfsd.springboot.services;

import java.util.Optional;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;

public interface UserService {
    Optional<Student> findStudentByUsername(String username);
    Optional<Faculty> findFacultyByUsername(String username);
    Optional<Admin> findAdminByUsername(String username);
}