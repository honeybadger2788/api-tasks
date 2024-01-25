package com.noeliacarosella.apitask.components;

import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class TaskLoader implements ApplicationRunner {

    @Autowired
    TaskRepository taskRepository;

    private void loadDummyData() {
        List<Task> dummyTasks = Arrays.asList(
                new Task("Task 1", "Description 1"),
                new Task("Task 2", "Description 2"),
                new Task("Task 3", "Description 3")
        );

        taskRepository.saveAll(dummyTasks);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadDummyData();
    }
}
