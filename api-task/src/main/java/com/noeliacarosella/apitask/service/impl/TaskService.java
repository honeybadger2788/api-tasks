package com.noeliacarosella.apitask.service.impl;

import com.noeliacarosella.apitask.exceptions.ResourceNotFoundException;
import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.repository.TaskRepository;
import com.noeliacarosella.apitask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task create(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task update(Task task) throws ResourceNotFoundException {
        Optional<Task> existingTask = taskRepository.findById(task.getId());
        if (existingTask.isPresent()) {
            return taskRepository.save(task);
        } else {
            throw new ResourceNotFoundException("Task Not Found");
        }
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            taskRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Task Not Found");
        }
    }
}
