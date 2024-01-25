package com.noeliacarosella.apitask.controller;

import com.noeliacarosella.apitask.exceptions.ResourceNotFoundException;
import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    ITaskService taskService;
    @PostMapping("/add")
    public ResponseEntity<Task> postTask(@Valid @RequestBody Task task) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task) throws ResourceNotFoundException {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.update(task));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) throws ResourceNotFoundException {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task deleted");
    }
}
