package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Question;
import com.takima.backskeleton.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Long> {
    @Query("SELECT q.questions FROM Quiz q WHERE q.id= :quizId")
    List<Question> getAllQuestionsFromQuiz(Long quizId);
}
