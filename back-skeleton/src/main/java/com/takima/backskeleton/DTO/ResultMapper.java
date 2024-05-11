package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Result;
import java.io.IOException;

/***
 * This class is used to map a ResultDto to a Result
 */
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
}
