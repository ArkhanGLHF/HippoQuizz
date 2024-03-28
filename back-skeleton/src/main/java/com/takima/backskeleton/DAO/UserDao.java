package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // => Anotation/Decorateur SPRING
public interface UserDao extends CrudRepository<User, Long> {

}
