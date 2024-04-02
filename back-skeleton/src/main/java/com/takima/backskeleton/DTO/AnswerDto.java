package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class AnswerDto {
    private String answerText;
    private boolean isCorrect;
    private String answerPicture;
    private Question question;

}
