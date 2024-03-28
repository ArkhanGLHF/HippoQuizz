package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private String username;
    private String email;
    private String password;

}
