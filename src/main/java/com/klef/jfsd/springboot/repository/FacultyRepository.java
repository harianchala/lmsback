package com.klef.jfsd.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByUsername(String username);
}
