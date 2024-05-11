package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

/***
 * This class contains the model to map a User
 * */
@Builder
@Getter

public class UserDto {
    private String username;
    private String email;
    private String password;

}
