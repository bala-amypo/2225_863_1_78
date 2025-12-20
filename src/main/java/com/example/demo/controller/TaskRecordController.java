package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/tasks")
public class TaskRecordController {

    private final TaskRecordService taskRecordService;
    private final TaskAssignmentService taskAssignmentService;

    public TaskRecordController(TaskRecordService taskRecordService,
                                TaskAssignmentService taskAssignmentService) {
        this.taskRecordService = taskRecordService;
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping
    public ResponseEntity<TaskRecord> createTask(@RequestBody TaskRecord task) {
        TaskRecord savedTask = taskRecordService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PostMapping("/{taskId}/assign")
    public ResponseEntity<?> assignTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskAssignmentService.assignTask(taskId));
    }
}
