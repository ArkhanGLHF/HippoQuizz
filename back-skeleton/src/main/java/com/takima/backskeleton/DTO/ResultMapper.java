package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Result;

import java.io.IOException;

public class ResultMapper {
    public static Result fromDto(ResultDto dto, Long id) throws IOException {
        return new Result.Builder()
                .id(id)
                .score(dto.getScore())
                .dateCompleted(dto.getDateCompleted())
                .user(dto.getUser())
                .quiz(dto.getQuiz())
                .build();
    }

    public static ResultDto toDto (Result result){
        return ResultDto.builder()
                .score(result.getScore())
                .dateCompleted(result.getDateCompleted())
                .user(result.getUser())
                .quiz(result.getQuiz())
                .build();
    }
}
