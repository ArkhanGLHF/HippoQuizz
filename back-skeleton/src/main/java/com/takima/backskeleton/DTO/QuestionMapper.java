package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Question;

import java.io.IOException;

public class QuestionMapper {
    public static Question fromDto(QuestionDto dto, Long id) throws IOException {
        return new Question.Builder()
                .id(id)
                .questionText(dto.getQuestionText())
                .questionPicture(dto.getQuestionPicture())
                .quiz(dto.getQuiz())
                .build();
    }

    public static QuestionDto toDto (Question question){
        return QuestionDto.builder()
                .questionText(question.getQuestionText())
                .questionPicture(question.getQuestionPicture())
                .quiz(question.getQuiz())
                .build();
    }
}
