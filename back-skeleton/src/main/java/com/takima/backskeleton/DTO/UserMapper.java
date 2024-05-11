package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.User;
import java.io.IOException;

/***
 * This class is used to map a UserDto to a User
 * */
public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return new User.Builder()
            .id(id)
            .username(dto.getUsername())
            .email(dto.getEmail())
            .password(dto.getPassword())
            .build();
    }
}
