package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

/***
 * This class contains the model to map a Quiz
 */
@Builder
@Getter

public class QuizDto {
    private String title;
    private String description;
}
