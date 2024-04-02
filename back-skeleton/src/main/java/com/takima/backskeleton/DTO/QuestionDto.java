package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class QuestionDto {
    private String questionText;
    private String questionPicture;
    private Quiz quiz;
}
