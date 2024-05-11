package com.takima.backskeleton.DAO;

import org.springframework.data.jpa.repository.Query;
import com.takima.backskeleton.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/***
 * This interface is used to manage the Question entity
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    /***
     * This method is used to get all questions from a quiz
     * @param id : the id of the quiz
     * @return a list of questions
     */
    @Query("SELECT q FROM Question q WHERE q.quiz.id = :id")
    List<Question> getAllQuestionsFromQuiz(Long id);
}
