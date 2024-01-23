package com.noeliacarosella.apitask.service.impl;

import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.repository.TaskRepository;
import com.noeliacarosella.apitask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;

public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }
}
