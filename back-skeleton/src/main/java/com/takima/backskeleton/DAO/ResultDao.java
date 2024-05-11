package com.takima.backskeleton.DAO;

import com.takima.backskeleton.models.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/***
 * This interface is used to manage the Result entity
 */
@Repository
public interface ResultDao extends CrudRepository<Result, Long> {

}
