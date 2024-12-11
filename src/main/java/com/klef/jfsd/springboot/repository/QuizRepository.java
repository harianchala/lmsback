package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.model.QuizAnswer;

public interface QuizRepository extends JpaRepository<QuizAnswer, Long> {}
