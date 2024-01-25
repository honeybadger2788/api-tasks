package com.noeliacarosella.apitask.service;

import com.noeliacarosella.apitask.exceptions.ResourceNotFoundException;
import com.noeliacarosella.apitask.model.Task;

import java.util.List;

public interface ITaskService {
    Task create(Task task);
    List<Task> listTasks();
    Task update(Task task) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}
