package com.takima.backskeleton.controllers;

import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.models.User;
import com.takima.backskeleton.services.ResultService;
import com.takima.backskeleton.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 * The class UserController is used to manage the User entity
 * => It's the API entry point
 */
@CrossOrigin
@RequestMapping("users")
@RestController
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;
    private final ResultService resultService;

    /***
     * This method is used to get all users
     * @return a list of users
     */
    @GetMapping("") // URL MAPPING  => localhost:8080/users
    public List<User> listUsers() { return userService.findAll(); }

    /***
     * This method is used to get a user by its id
     * @param id : the id of the user
     * @return a user
     */
    @GetMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    /***
     * This method is used to delete a user by its id
     * @param id : the id of the user
     */
    @DeleteMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public void deleteUser(@PathVariable Long id) {
        resultService.deleteByUserId(id);
        userService.deleteById(id);
    }

    /***
     * This method is used to add a user
     * @param userDto : the user to add
     */
    @PostMapping("")    // URL MAPPING => localhost:8080/users
    public void addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
    }

    /***
     * This method is used to update a user
     * @param UserDto : the user to update
     * @param id : the id of the user
     */
    @PostMapping("/{id}") // URL EXTENSION => localhost:8080/users/{id}
    public void updateUser(@RequestBody UserDto UserDto, @PathVariable Long id) {
        userService.updateUser(UserDto, id);
    }
}
