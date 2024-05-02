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

@Component
@RequiredArgsConstructor
public class QuizService {
    private final QuizDao quizDao;

    public List<Quiz> findAll() {
        Iterable<Quiz> it = quizDao.findAll();
        List <Quiz> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes;
    }

    public Quiz getById(Long id) {
        return quizDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        quizDao.deleteById(id);
    }

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
