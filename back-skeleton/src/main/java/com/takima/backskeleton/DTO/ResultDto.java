package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Quiz;
import com.takima.backskeleton.models.User;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

/***
 * This class contains the model to map a Result
 */
@Builder
@Getter

public class ResultDto {
    private User user;
    private Quiz quiz;
    private int score;
    private Date dateCompleted;
}
