package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Major;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("quiz")
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("")
    public List<Quiz> findAll() {
        return quizService.findAll();
    }

    @GetMapping("/{id}/questions")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long id) {
        return quizService.getQuestionsOfQuiz(id);
    }
}
