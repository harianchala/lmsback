package com.klef.jfsd.springboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Faculty;

import com.klef.jfsd.springboot.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
 
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public Faculty createFaculty(Faculty faculty) {
		   return facultyRepository.save(faculty);
	}

	@Override
	public List<Faculty> getAllFacultys() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFacultyById(Long id) {
		 return facultyRepository.findById(id).orElse(null);
	}

	@Override
	public String updateFaculty(Long id, Faculty faculty) {
	    Faculty existingFaculty = facultyRepository.findById(id).orElse(null);
        if (existingFaculty==null) {
            return "Faculty not found";
        }
        existingFaculty.setUsername(faculty.getUsername());
        existingFaculty.setFullname(faculty.getFullname());
        existingFaculty.setPassword(faculty.getPassword());
        existingFaculty.setEmail(faculty.getEmail());
        existingFaculty.setPhonenumber(faculty.getPhonenumber());
        existingFaculty.setAge(faculty.getAge());
        existingFaculty.setDepartment(faculty.getDepartment());
        existingFaculty.setGender(faculty.getGender());
        existingFaculty.setAddress(faculty.getAddress());
        existingFaculty.setJoiningdate(faculty.getJoiningdate());
        existingFaculty.setSalaray(faculty.getSalaray());
        facultyRepository.save (existingFaculty);
        return "Faculty updated successfully";
	}

	@Override
	public String deleteFaculty(Long id) {
		if (!facultyRepository.existsById(id)) {
            return "Faculty not found";
        }
       facultyRepository.deleteById(id);
        return "Faculty deleted successfully";
	}

}
