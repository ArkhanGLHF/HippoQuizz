package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * This interface is used to manage the Quiz entity
 */
@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {
    /***
     * This method is used to get the last created quiz
     * @return the last created quiz
     */
    @Query("SELECT q FROM Quiz q ORDER BY q.id DESC LIMIT 1")
    Quiz getLastCreatedQuiz();
}
