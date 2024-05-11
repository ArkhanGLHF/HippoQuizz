package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Result;

import java.io.IOException;

public class ResultMapper {
    public static Result fromDto(ResultDto dto, Long id) throws IOException {
        return new Result.Builder()
            .id(id)
            .user(dto.getUser())
            .quiz(dto.getQuiz())
            .score(dto.getScore())
            .dateCompleted(dto.getDateCompleted())
            .build();
    }

    public ResultDto ToDo (Result result){
        return ResultDto.builder()
                .score(result.getScore())
                .user(result.getUser())
                .quiz(result.getQuiz())
                .dateCompleted(result.getDateCompleted())
                .build();
    }
}
