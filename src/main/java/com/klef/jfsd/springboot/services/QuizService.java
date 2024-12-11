package com.klef.jfsd.springboot.services;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.QuizAnswer;
import com.klef.jfsd.springboot.repository.QuizRepository;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository repository;

    public QuizService(QuizRepository repository) {
        this.repository = repository;
    }

    public void saveAllAnswers(List<QuizAnswer> answers) {
        repository.saveAll(answers);
    }
}
