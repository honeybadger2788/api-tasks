package com.noeliacarosella.apitask.controller;

import com.noeliacarosella.apitask.model.Task;
import com.noeliacarosella.apitask.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    ITaskService taskService;
    @PostMapping("/add")
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.create(task));
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.update(task));
    }
}
