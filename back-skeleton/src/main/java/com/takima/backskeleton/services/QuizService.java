package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.QuizDao;
import com.takima.backskeleton.DTO.QuizDto;
import com.takima.backskeleton.DTO.QuizMapper;
import com.takima.backskeleton.models.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizDao quizDao;

    public List<Quiz> findAll() {
        Iterable<Quiz> it = quizDao.findAll();
        List <Quiz> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
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
            throw new RuntimeException("Error with Quiz image", e);
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
            throw new RuntimeException("Error with Quiz image", e);
        }
        quizDao.save(quiz);
    }
}
