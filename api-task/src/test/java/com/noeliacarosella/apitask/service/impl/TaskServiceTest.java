package com.noeliacarosella.apitask.service.impl;

import com.noeliacarosella.apitask.exceptions.ResourceNotFoundException;
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
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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

    @Test
    public void testUpdateTask() throws ResourceNotFoundException {
        Task existingTask = dummyTasks.get(0);
        when(taskRepository.findById(existingTask.getId())).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(existingTask);

        Task updatedTask = taskService.update(existingTask);

        Assertions.assertEquals(existingTask, updatedTask);
    }

    @Test
    public void testUpdateTaskNotFound() {
        Long nonExistingTaskId = 100L;
        when(taskRepository.findById(nonExistingTaskId)).thenReturn(Optional.empty());

        Task nonExistingTask = new Task("Non-existing Task", "Non-existing Description");
        assertThrows(ResourceNotFoundException.class, () -> taskService.update(nonExistingTask));
    }

    @Test
    public void testDeleteTask() throws ResourceNotFoundException {
        Task existingTask = dummyTasks.get(0);
        when(taskRepository.findById(existingTask.getId())).thenReturn(Optional.of(existingTask));

        taskService.delete(existingTask.getId());

        verify(taskRepository, times(1)).deleteById(existingTask.getId());
    }

    @Test
    public void testDeleteTaskNotFound() {
        when(taskRepository.findById(100L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> taskService.delete(100L));
    }
}