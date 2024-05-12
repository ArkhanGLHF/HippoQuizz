package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.QuizDto;
import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.services.QuizService;
import com.takima.backskeleton.services.QuestionService;
import com.takima.backskeleton.services.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * The class QuizController is used to manage the Quiz entity
 * => It's the API entry point
 */
@CrossOrigin
@RequestMapping("")
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;
    private final ResultService resultService;

    /***
     * This method is used to get all quizzes
     * @return a list of quizzes
     */
    @GetMapping("quiz")
    public List<Quiz> listQuiz() {
        return quizService.findAll();
    }

    /***
     * This method is used to get a quiz by its id
     * @param id : the id of the quiz
     * @return a quiz
     */
    @GetMapping("quiz/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getById(id);
    }

    /***
     * This method is used to delete a quiz by its id
     * @param id : the id of the quiz
     */
    @DeleteMapping("quiz-configuration/{id}") // URL EXTENSION => localhost:8080/quiz-configuration/{id}
    public void deleteQuiz(@PathVariable Long id) {
        resultService.deleteByQuizId(id);
        questionService.deleteQuestionsOfQuiz(id);
        quizService.deleteById(id);
    }

    /***
     * This method is used to add a quiz
     * @param quizDto : the quiz to add
     */
    @PostMapping("quiz-configuration-new/")    // URL MAPPING => localhost:8080/quiz-configuration-new/
    public void addQuiz(@RequestBody QuizDto quizDto) {
        quizService.addQuiz(quizDto);
    }


    /***
     * This method is used to get the last created quiz
     * @return the last created quiz
     */
    @GetMapping("quiz-configuration-new/") // URL EXTENSION => localhost:8080/quiz-configuration-new/
    public Quiz getLastCreatedQuiz() {
        return quizService.getLastCreatedQuiz();
    }

    /***
     * This method is used to update a quiz
     * @param quizDto : the quiz to update
     * @param id : the id of the quiz
     */
    @PostMapping("quiz-configuration-details/{id}") // URL EXTENSION => localhost:8080/quiz/{id}
    public void updateQuiz(@RequestBody QuizDto quizDto, @PathVariable Long id) {
        quizService.updateQuiz(quizDto, id);
    }

}
