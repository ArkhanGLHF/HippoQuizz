package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * This interface is used to manage the Quiz entity
 */
@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {

}
