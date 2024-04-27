package com.takima.backskeleton.controllers;

/*
    Vitrine de notre API
        Pour rentrer dans le truc c'est fourniture
 */

import com.takima.backskeleton.DTO.ResultDto;
import com.takima.backskeleton.models.Result;
import com.takima.backskeleton.services.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("results")
@RestController
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @GetMapping("") // URL MAPPING  => localhost:8080/results
    public List<Result> listResults() { return resultService.findAll(); }

    @GetMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public Result getResultById(@PathVariable Long id) {
        return resultService.getById(id);
    }

    @DeleteMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public void deleteResult(@PathVariable Long id) {
        resultService.deleteById(id);
    }

    @PostMapping("")    // URL MAPPING => localhost:8080/results
    public void addResult(@RequestBody ResultDto resultDto) {
        resultService.addResult(resultDto);
    }

    @PostMapping("/{id}") // URL EXTENSION => localhost:8080/results/{id}
    public void updateResult(@RequestBody ResultDto ResultDto, @PathVariable Long id) {
        resultService.updateResult(ResultDto, id);
    }
}
