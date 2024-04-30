package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Result;
import com.takima.backskeleton.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultDao extends CrudRepository<Result, Long> {
    @Query("SELECT r FROM Result r JOIN r.user u WHERE u.id = :userId")
    List<Result> findByUserId(Long userId);
}
