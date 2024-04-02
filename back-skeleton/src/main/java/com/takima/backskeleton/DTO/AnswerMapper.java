package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Answer;
import com.takima.backskeleton.models.Question;

import java.io.IOException;

public class AnswerMapper {
    public static Answer fromDto(AnswerDto dto, Long id) throws IOException {
        return new Answer.Builder()
                .id(id)
                .answerText(dto.getAnswerText())
                .isCorrect(dto.isCorrect())
                .answerPicture(dto.getAnswerPicture())
                .question(dto.getQuestion())
                .build();
    }

    public static AnswerDto toDto (Answer answer){
        return AnswerDto.builder()
                .answerText(answer.getAnswerText())
                .isCorrect(answer.isCorrect())
                .answerPicture(answer.getAnswerPicture())
                .question(answer.getQuestion())
                .build();
    }
}
