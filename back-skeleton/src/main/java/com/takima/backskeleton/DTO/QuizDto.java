package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Course;
import com.takima.backskeleton.models.Major;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Builder
@Getter
public class QuizDto {
    private String title;
    private String description;
}
