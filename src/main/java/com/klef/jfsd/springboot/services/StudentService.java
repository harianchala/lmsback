package com.klef.jfsd.springboot.services;
import java.util.List;

import com.klef.jfsd.springboot.model.Student;
public interface StudentService {
	 Student createStudent(Student student);
	    List<Student> getAllStudents();
	    Student getStudentById(Long id);
	    String updateStudent(Long id, Student student);
	    String deleteStudent(Long id);
}
