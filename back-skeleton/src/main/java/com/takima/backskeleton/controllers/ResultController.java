package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.ResultDto;
import com.takima.backskeleton.models.Result;
import com.takima.backskeleton.services.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * The class ResultController is used to manage the Result entity
 * => It's the API entry point
 */
@CrossOrigin
@RequestMapping("results")
@RestController
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    /***
     * This method is used to get all results
     * @return a list of results
     */
    @GetMapping("") // URL MAPPING  => localhost:8080/results
    public List<Result> listResults() { return resultService.findAll(); }

    /***
     * This method is used to get a result by its id
     * @param id : the id of the result
     * @return a result
     */
    @GetMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public Result getResultById(@PathVariable Long id) {
        return resultService.getById(id);
    }

    /***
     * This method is used to delete a result by its id
     * @param id : the id of the result
     */
    @DeleteMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public void deleteResult(@PathVariable Long id) {
        resultService.deleteById(id);
    }

    /***
     * This method is used to add a result
     * @param resultDto : the result to add
     */
    @PostMapping("")    // URL MAPPING => localhost:8080/results
    public void addResult(@RequestBody ResultDto resultDto) {
        resultService.addResult(resultDto);
    }

    /***
     * This method is used to update a result
     * @param ResultDto : the result to update
     * @param id : the id of the result
     */
    @PostMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public void updateResult(@RequestBody ResultDto ResultDto, @PathVariable Long id) {
        resultService.updateResult(ResultDto, id);
    }
}
