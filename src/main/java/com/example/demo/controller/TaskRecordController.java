package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService taskRecordService;

    public TaskRecordController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        TaskRecord savedTask = taskRecordService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskRecord> getTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskRecordService.getTaskById(id));
    }
}
