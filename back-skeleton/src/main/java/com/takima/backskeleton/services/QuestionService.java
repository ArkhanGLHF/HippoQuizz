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

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionDao questionDao;

    public List<Question> findAll() {
        Iterable<Question> it = questionDao.findAll();
        List <Question> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Question getById(Long id) {

        return questionDao.findById(id).orElseThrow();
    }

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

    @Transactional
    public void deleteById(Long id) {
        questionDao.deleteById(id);
    }

    /***
     * Method that deletes the questions of a specific quiz.
     * @param id The ID of the quiz whose questions we want to delete.
     */
    @Transactional
    public  void deleteQuestionsOfQuiz(Long id) {
        List<Question> quizQuestions = findByQuizId(id);
        for (Question q : quizQuestions) {
            Long questionId = q.getId();
            questionDao.deleteById(questionId);
        }
    }

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
