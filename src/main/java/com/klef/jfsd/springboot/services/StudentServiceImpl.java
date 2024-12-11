package com.klef.jfsd.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public String updateStudent(Long id, Student student) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent == null) {
            return "Student not found";
        }
        existingStudent.setUsername(student.getUsername());
        existingStudent.setFullname(student.getFullname());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPhonenumber(student.getPhonenumber());
        existingStudent.setYear(student.getYear());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setGender(student.getGender());
        studentRepository.save(existingStudent);
        return "Student updated successfully";
    }

    @Override
    public String deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            return "Student not found";
        }
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }
}
