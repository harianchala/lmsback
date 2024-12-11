package com.klef.jfsd.springboot.services;

import java.util.List;

import com.klef.jfsd.springboot.model.Faculty;

public interface FacultyService {
  Faculty createFaculty(Faculty faculty);
    List<Faculty> getAllFacultys();
    Faculty getFacultyById(Long id);
    String updateFaculty(Long id, Faculty faculty);
    String deleteFaculty(Long id);
}
