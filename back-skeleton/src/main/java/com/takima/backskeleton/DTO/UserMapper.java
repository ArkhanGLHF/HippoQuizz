package com.takima.backskeleton.DTO;

import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.User;

import java.io.IOException;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return new User.Builder()
                .id(id)
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }

    public static StudentDto toDto (Student student){
        return StudentDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .birthdate(student.getBirthdate())
                .courses(student.getCourses())
                .major(student.getMajor())
                .build();
    }
}
