package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.AnswerDao;
import com.takima.backskeleton.DTO.AnswerDto;
import com.takima.backskeleton.DTO.AnswerMapper;
import com.takima.backskeleton.models.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerDao answerDao;

    public List<Answer> findAll() {
        Iterable<Answer> it = answerDao.findAll();
        List <Answer> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Answer getById(Long id) {
        return answerDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        answerDao.deleteById(id);
    }

    @Transactional
    public void addAnswer(AnswerDto answerDto) {
        Answer answer;
        try {
            answer = AnswerMapper.fromDto(answerDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Answer image", e);
        }

        answerDao.save(answer);
    }

    @Transactional
    public void updateAnswer(AnswerDto answerDto, Long id) {
        answerDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Answer doesn't exist"));
        Answer answer;
        try {
            answer = AnswerMapper.fromDto(answerDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Answer image", e);
        }
        answerDao.save(answer);
    }
}
