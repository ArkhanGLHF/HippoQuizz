package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuizDao;
import com.takima.backskeleton.DTO.QuizDto;
import com.takima.backskeleton.DTO.QuizMapper;
import com.takima.backskeleton.models.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/***
 * Service class for the Quiz entity.
 */
@Component
@RequiredArgsConstructor

public class QuizService {
    private final QuizDao quizDao;

    /***
     * Method that retrieves all the quizzes.
     * @return A list containing all the quizzes.
     */
    public List<Quiz> findAll() {
        Iterable<Quiz> it = quizDao.findAll();
        List <Quiz> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes;
    }

    /***
     * Method that retrieves a specific quiz.
     * @param id : The ID of the quiz we want to retrieve.
     * @return The quiz with the given ID.
     */
    public Quiz getById(Long id) {
        return quizDao.findById(id).orElseThrow();
    }

    /***
     * Method that delete a quiz by a specific user.
     * @param id : The ID of the quiz we want to delete.
     */
    @Transactional
    public void deleteById(Long id) {
        quizDao.deleteById(id);
    }

    /***
     * Method that adds a quiz.
     * @param quizDto : The DTO containing the information of the quiz we want to add.
     */
    @Transactional
    public void addQuiz(QuizDto quizDto) {
        Quiz quiz;
        try {
            quiz = QuizMapper.fromDto(quizDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Quiz", e);
        }
        quizDao.save(quiz);
    }

    /***
     * Method that retrieves the last created quiz.
     * @return The last created quiz.
     */
    @Transactional
    public Quiz getLastCreatedQuiz() {
        return quizDao.getLastCreatedQuiz();
    }


    /***
     * Method that updates a quiz.
     * @param quizDto : The DTO containing the information of the quiz we want to update.
     * @param id : The ID of the quiz we want to update.
     */
    @Transactional
    public void updateQuiz(QuizDto quizDto, Long id) {
        quizDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Quiz doesn't exist"));
        Quiz quiz;
        try {
            quiz = QuizMapper.fromDto(quizDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Quiz", e);
        }
        quizDao.save(quiz);
    }
}
