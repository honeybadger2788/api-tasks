package com.noeliacarosella.apitask.repository;

import com.noeliacarosella.apitask.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
}
