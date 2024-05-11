package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultDao extends CrudRepository<Result, Long> {

}
