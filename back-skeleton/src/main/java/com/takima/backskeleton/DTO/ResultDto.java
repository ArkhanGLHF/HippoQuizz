package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.models.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Builder
@Getter
public class ResultDto {
    private int score;
    private Date dateCompleted;
    private User user;
    private Quiz quiz;
}