package com.klef.jfsd.springboot.controller;

import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.model.QuizAnswer;
import com.klef.jfsd.springboot.services.QuizService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "*", allowedMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"})
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service) {
        this.service = service;
    }

    @PostMapping("/submit")
    public String submitQuiz(@RequestBody List<QuizAnswer> answers) {
        service.saveAllAnswers(answers);
        return "Quiz submitted successfully!";
    }
}
