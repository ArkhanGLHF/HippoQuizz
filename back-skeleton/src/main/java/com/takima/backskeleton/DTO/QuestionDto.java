package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;
import lombok.Builder;
import lombok.Getter;

/***
 * This class contains the model to map a Question
 */
@Builder
@Getter
public class QuestionDto {
    private Quiz quiz;
    private String questionText;
    private boolean questionAnswer;
}
