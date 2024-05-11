package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * This interface is used to manage the User entity
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

}
