package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuizDao;
import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.models.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizService {
    private final QuizDao quizDao;

    public List<Quiz> findAll() {
        Iterable<Quiz> it = quizDao.findAll();
        List <Quiz> quizzes = new java.util.ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes;
    }

    public List<Question> getQuestionsOfQuiz(Long id) {
        return quizDao.getAllQuestionsFromQuiz(id);
    }
}
