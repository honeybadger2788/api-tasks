package com.noeliacarosella.apitask.service;

import com.noeliacarosella.apitask.model.Task;

import java.util.List;

public interface ITaskService {
    public Task create(Task task);
    public List<Task> listTasks();
}
