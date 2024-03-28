package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;

import java.io.IOException;

public class QuizMapper {
    public static Quiz fromDto(QuizDto dto, Long id) throws IOException {
        return new Quiz.Builder()
                .id(id)
                .title(dto.getTitle())
                .description(dto.getDescription())
                .build();
    }

    public static QuizDto toDto (Quiz quiz){
        return QuizDto.builder()
                .title(quiz.getTitle())
                .description(quiz.getDescription())
                .build();
    }
}
