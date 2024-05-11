package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuestionDto;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("questions")
@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("")
    public List<Question> listQuestions() { return questionService.findAll(); }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long id) {
        return questionService.getQuestionsOfQuiz(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    @PostMapping("")
    public void addQuestion(@RequestBody QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
    }

    @PostMapping("/{id}")
    public void updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable Long id) {
        questionService.updateQuestion(questionDto, id);
    }
}
