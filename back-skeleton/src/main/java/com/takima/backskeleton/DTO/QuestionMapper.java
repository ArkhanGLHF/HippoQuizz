package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Question;
import java.io.IOException;

/***
 * This class is used to map a QuestionDto to a Question
 */
public class QuestionMapper {
    public static Question fromDto(QuestionDto dto, Long id) throws IOException {
        return new Question.Builder()
                .id(id)
                .quiz(dto.getQuiz())
                .questionText(dto.getQuestionText())
                .questionAnswer(dto.isQuestionAnswer())
                .build();
    }
}
