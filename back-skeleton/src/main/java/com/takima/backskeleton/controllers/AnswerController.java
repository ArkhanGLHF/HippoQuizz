package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.AnswerDto;
import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.models.Answer;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.services.AnswerService;
import com.takima.backskeleton.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("answers")
@RestController
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @GetMapping("")
    public List<Answer> listStudents(){
        return answerService.findAll();
    }

    @GetMapping("/{id}")
    public Answer geAnswerById(@PathVariable Long id) {
        return answerService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerService.deleteById(id);
    }

    @PostMapping("")
    public void addAnswer(@RequestBody AnswerDto answerDto) {
        answerService.addAnswer(answerDto);
    }

    @PostMapping("/{id}")
    public void updateAnswer(@RequestBody AnswerDto answerdto, @PathVariable Long id) {
        answerService.updateAnswer(answerdto, id);
    }
}
