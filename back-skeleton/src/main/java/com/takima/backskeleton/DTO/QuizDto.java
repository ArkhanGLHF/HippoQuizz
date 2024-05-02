package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class QuizDto {
    private String title;
    private String description;
}
