package com.takima.backskeleton.controllers;

/*
    Vitrine de notre API
        Pour rentrer dans le truc c'est fourniture
 */

import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("") // URL MAPPING  => localhost:8080/users
    public List<User> listUsers() { return userService.findAll(); }

    @GetMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PostMapping("")    // URL MAPPING => localhost:8080/users
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public void updateUser(@RequestBody UserDto UserDto, @PathVariable Long id) {
        userService.updateUser(UserDto, id);
    }
}
