package com.takima.backskeleton.DAO;

import org.springframework.data.jpa.repository.Query;
import com.takima.backskeleton.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.quiz.id = :id")
    List<Question> getAllQuestionsFromQuiz(Long id);
}
