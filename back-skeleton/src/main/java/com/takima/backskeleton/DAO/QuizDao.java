package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {

}
