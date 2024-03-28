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

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao; // Injection de dépendance => Pour utiliser le DAO


    /*
        Explication : Récupère tous les utilisateurs
     */
    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users;
    }

    public User getById(Long id) {
        return userDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

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

    public List<User> searchByMajorAndCourse(int majorId, int courseId) {
        return userDao.findByMajorIdAndCourseId(majorId, courseId);
    }
}
