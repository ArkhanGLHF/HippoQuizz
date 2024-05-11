package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuestionDao;
import com.takima.backskeleton.DTO.QuestionDto;
import com.takima.backskeleton.DTO.QuestionMapper;
import com.takima.backskeleton.models.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/***
 * Service class for the Question entity.
 */
@Service
@RequiredArgsConstructor

public class QuestionService {
    private final QuestionDao questionDao;

    /***
     * Method that retrieves all the questions.
     * @return A list containing all the questions.
     */
    public List<Question> findAll() {
        Iterable<Question> it = questionDao.findAll();
        List <Question> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    /***
     * Method that retrieves a specific question.
     * @param id : The ID of the question we want to retrieve.
     * @return The question with the given ID.
     */
    public Question getById(Long id) {

        return questionDao.findById(id).orElseThrow();
    }

    /***
     * Method that retrieves the questions of a specific quiz.
     * @param id : The ID of the quiz whose questions we want to retrieve.
     * @return A list containing the questions of a specific quiz with the given ID.
     */
    public List<Question> getQuestionsOfQuiz(Long id) {
        return questionDao.getAllQuestionsFromQuiz(id);
    }

    /***
     * Method that retrieves the questions of a specific quiz.
     * @param id : The ID of the quiz whose questions we want to retrieve.
     * @return A list containing the questions of a specific quiz with the given ID.
     */
    public List<Question> findByQuizId(Long id){
        Iterable<Question> allQuestions = questionDao.findAll();
        List <Question> questions = new ArrayList<>();
        allQuestions.forEach(q -> {
            if (q.getQuiz() != null && q.getQuiz().getId().equals(id)) {
                questions.add(q);
            }
        });
        return questions;
    }

    /***
     * Method that deletes a specific question.
     * @param id : The ID of the question we want to delete.
     */
    @Transactional
    public void deleteById(Long id) {
        questionDao.deleteById(id);
    }

    /***
     * Method that deletes the questions of a specific quiz.
     * @param id : The ID of the quiz whose questions we want to delete.
     */
    @Transactional
    public  void deleteQuestionsOfQuiz(Long id) {
        List<Question> quizQuestions = findByQuizId(id);
        for (Question q : quizQuestions) {
            Long questionId = q.getId();
            questionDao.deleteById(questionId);
        }
    }

    /***
     * Method that adds a question.
     * @param questionDto : The DTO containing the information of the question we want to add.
     */
    @Transactional
    public void addQuestion(QuestionDto questionDto) {
        Question question;
        try {
            question = QuestionMapper.fromDto(questionDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Question image", e);
        }

        questionDao.save(question);
    }

    /***
     * Method that updates a question.
     * @param questionDto : The DTO containing the information of the question we want to update.
     * @param id : The ID of the question we want to update.
     */
    @Transactional
    public void updateQuestion(QuestionDto questionDto, Long id) {
        questionDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Question doesn't exist"));
        Question question;
        try {
            question = QuestionMapper.fromDto(questionDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Question image", e);
        }
        questionDao.save(question);
    }
}
