package com.takima.backskeleton.services;


import com.takima.backskeleton.DAO.ResultDao;
import com.takima.backskeleton.DAO.ResultDao;
import com.takima.backskeleton.DTO.ResultDto;
import com.takima.backskeleton.DTO.ResultMapper;
import com.takima.backskeleton.models.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultDao resultDao;

    public List<Result> findAll() {
        Iterable<Result> it = resultDao.findAll();
        List <Result> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Result getById(Long id) {
        return resultDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        resultDao.deleteById(id);
    }

    @Transactional
    public void addResult(ResultDto resultDto) {
        Result result;
        try {
            result = ResultMapper.fromDto(resultDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Result image", e);
        }

        resultDao.save(result);
    }

    @Transactional
    public void updateResult(ResultDto resultDto, Long id) {
        resultDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Result doesn't exist"));
        Result result;
        try {
            result = ResultMapper.fromDto(resultDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Result image", e);
        }
        resultDao.save(result);
    }
}
