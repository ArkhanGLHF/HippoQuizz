package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuestionDto;
import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * The class QuestionController is used to manage the Question entity
 * => It's the API entry point
 */
@CrossOrigin
@RequestMapping("questions")
@RestController
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    /***
     * This method is used to get all questions
     * @return a list of questions
     */
    @GetMapping("")
    public List<Question> listQuestions() { return questionService.findAll(); }

    /***
     * This method is used to get a question by its id
     * @param id : the id of the question
     * @return a question
     */
    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id) {
        return questionService.getById(id);
    }

    /***
     * This method is used to get all questions from a quiz
     * @param id : the id of the quiz
     * @return a list of questions
     */
    @GetMapping("/quiz/{id}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long id) {
        return questionService.getQuestionsOfQuiz(id);
    }

    /***
     * This method is used to delete a question by its id
     * @param id : the id of the question
     */
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteById(id);
    }

    /***
     * This method is used to add a question
     * @param questionDto : the question to add
     */
    @PostMapping("")
    public void addQuestion(@RequestBody QuestionDto questionDto) {
        questionService.addQuestion(questionDto);
    }

    /***
     * This method is used to update a question
     * @param questionDto : the question to update
     * @param id : the id of the question
     */
    @PostMapping("/{id}")
    public void updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable Long id) {
        questionService.updateQuestion(questionDto, id);
    }
}
