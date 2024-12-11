package com.klef.jfsd.springboot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Faculty;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.FacultyRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
    private StudentRepository studentRepository;
	
    @Autowired
    private FacultyRepository facultyRepository;
    
    @Autowired
    private AdminRepository adminRepository;

    @Override
    public Optional<Student> findStudentByUsername(String username) {
        return studentRepository.findByUsername(username);
    }

    @Override
    public Optional<Faculty> findFacultyByUsername(String username) {
        return facultyRepository.findByUsername(username);
    }

    @Override
    public Optional<Admin> findAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
