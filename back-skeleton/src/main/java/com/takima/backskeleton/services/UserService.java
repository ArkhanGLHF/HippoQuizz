package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.UserDao;
import com.takima.backskeleton.DTO.UserDto;
import com.takima.backskeleton.DTO.UserMapper;
import com.takima.backskeleton.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/***
 * Service class for the User entity.
 */
@Service
@RequiredArgsConstructor

public class UserService {
    private final UserDao userDao;

    /***
     * Method that retrieves all the users.
     * @return A list containing all the users.
     */
    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users;
    }

    /***
     * Method that retrieves a specific user.
     * @param id : The ID of the user we want to retrieve.
     * @return The user with the given ID.
     */
    public User getById(Long id) {
        return userDao.findById(id).orElseThrow();
    }

    /***
     * Method that deletes a specific user.
     * @param id : The ID of the user we want to delete.
     */
    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    /***
     * Method that adds a user.
     * @param UserDto : The DTO containing the information of the user we want to add.
     */
    @Transactional
    public void addUser(UserDto UserDto) {
        User user;
        try {
            user = UserMapper.fromDto(UserDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }
        userDao.save(user);
    }

    /***
     * Method that updates a user.
     * @param UserDto : The DTO containing the information of the user we want to update.
     * @param id : The ID of the user we want to update.
     */
    @Transactional
    public void updateUser(UserDto UserDto, Long id) {
        userDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist"));
        User user;
        try {
            user = UserMapper.fromDto(UserDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }
        userDao.save(user);
    }
}
