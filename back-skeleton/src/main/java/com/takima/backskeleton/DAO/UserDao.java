package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // => Anotation/Decorateur SPRING
public interface UserDao extends CrudRepository<User, Long> {

    @Query("SELECT s FROM Student s JOIN s.courses c WHERE c.id= :courseId AND s.major.id = :majorId ")
    List<User> findByMajorIdAndCourseId(int majorId, int courseId);
}
