package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuizDto;
import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.services.QuizService;
import com.takima.backskeleton.models.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("")
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;

    @GetMapping("quiz")
    public List<Quiz> listQuiz() {
        return quizService.findAll();
    }

    @GetMapping("quiz/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @DeleteMapping("quiz-configuration/{id}") // URL EXTENSION => localhost:8080/quiz/{id}
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @PostMapping("quiz-configuration-new/")    // URL MAPPING => localhost:8080/quiz
    public void addQuiz(@RequestBody QuizDto quizDto) {
        quizService.addQuiz(quizDto);
    }

    @PostMapping("quiz-configuration-details/{id}") // URL EXTENSION => localhost:8080/quiz/{id}
    public void updateQuiz(@RequestBody QuizDto quizDto, @PathVariable Long id) {
        quizService.updateQuiz(quizDto, id);
    }

}
