package com.takima.backskeleton.services;

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

/***
 * Service class for the Result entity.
 */
@Service
@RequiredArgsConstructor

public class ResultService {
    private final ResultDao resultDao;

    /***
     * Method that retrieves all the results.
     * @return A list containing all the results.
     */
    public List<Result> findAll() {
        Iterable<Result> it = resultDao.findAll();
        List <Result> results = new ArrayList<>();
        it.forEach(results::add);
        return results;
    }

    /***
     * Method that retrieves a specific result.
     * @param id : The ID of the result we want to retrieve.
     * @return The result with the given ID.
     */
    public Result getById(Long id) {
        return resultDao.findById(id).orElseThrow();
    }

    /***
     * Method that retrieves the results held by a specific user.
     * @param id : The ID of the user whose results we want to retrieve.
     * @return A list containing the results held by the user with the given ID.
     */
    public List<Result> findByUserId(Long id){
        Iterable<Result> allResults = resultDao.findAll();
        List <Result> results = new ArrayList<>();
        allResults.forEach(r -> {
            if (r.getUser() != null && r.getUser().getId().equals(id)) {
                results.add(r);
            }
        });
        return results;
    }

    /***
     * Method that deletes a specific result.
     * @param id : The ID of the result we want to delete.
     */
    @Transactional
    public void deleteById(Long id) {
        resultDao.deleteById(id);
    }

    /***
     * Method that deletes the results held by a specific user.
     * @param id The ID of the user whose results we want to delete.
     */
    @Transactional
    public  void deleteByUserId(Long id){
        List<Result> userResults = findByUserId(id);
        for (Result r : userResults){
            Long resultId = r.getId();
            resultDao.deleteById(resultId);
        }
    }

    /***
     * Method that adds a result.
     * @param resultDto : The DTO containing the information of the result we want to add.
     */
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

    /***
     * Method that updates a result.
     * @param resultDto : The DTO containing the information of the result we want to update.
     * @param id : The ID of the result we want to update.
     */
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
