package com.takima.backskeleton.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserDto {
    private long    id;
    private String firstName;
    private String lastName;
    private String password;

}
