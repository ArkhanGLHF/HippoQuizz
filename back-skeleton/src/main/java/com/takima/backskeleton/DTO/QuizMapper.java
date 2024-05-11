package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;
import java.io.IOException;

/***
 * This class is used to map a QuizDto to a Quiz
 */
public class QuizMapper {
    public static Quiz fromDto(QuizDto dto, Long id) throws IOException {
        return new Quiz.Builder()
                .id(id)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }
}
