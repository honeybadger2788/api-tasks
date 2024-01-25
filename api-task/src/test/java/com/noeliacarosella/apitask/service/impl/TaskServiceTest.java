package com.noeliacarosella.apitask.service.impl;

import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class TaskServiceTest {
    @Mock
    TaskRepository taskRepository;

    @InjectMocks
    TaskService taskService;

    private List<Task> dummyTasks;

    @BeforeEach
    public void setUp() {
        dummyTasks = new ArrayList<>();
        dummyTasks.add(new Task("Test Task 1", "Description 1"));
        dummyTasks.add(new Task("Test Task 2", "Description 2"));
        dummyTasks.add(new Task("Test Task 3", "Description 3"));
    }

    @Test
    public void testListTasks() {
        when(taskRepository.findAll()).thenReturn(dummyTasks);

        List<Task> result = taskService.listTasks();

        Assertions.assertEquals(dummyTasks, result);
    }

    @Test
    public void testCreateTask() {
        Task newTask = new Task("New Task", "New Description");
        when(taskRepository.save(newTask)).thenReturn(newTask);

        Task result = taskService.create(newTask);

        Assertions.assertEquals(newTask, result);
    }

}