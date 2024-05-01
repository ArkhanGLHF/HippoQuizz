package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuizDto;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quiz;
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
    public List<Quiz> listQuiz() {
        return quizService.findAll();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.findById(id);
    }

    @GetMapping("/{id}/questions")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long id) {
        return quizService.getQuestionsOfQuiz(id);
    }

    @DeleteMapping("/configuration/{id}") // URL EXTENSION => localhost:8080/quiz/{id}
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @PostMapping("/configuration/new")    // URL MAPPING => localhost:8080/quiz
    public void addQuiz(@RequestBody QuizDto quizDto) {
        quizService.addQuiz(quizDto);
    }

    @PostMapping("/configuration/{id}") // URL EXTENSION => localhost:8080/quiz/{id}
    public void updateQuiz(@RequestBody QuizDto quizDto, @PathVariable Long id) {
        quizService.updateQuiz(quizDto, id);
    }

}
