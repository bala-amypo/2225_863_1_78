package com.example.demo.controller;

import com.example.demo.model.TaskAssignment;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    @PostMapping
    public TaskAssignment save(@RequestBody TaskAssignment task) {
        return service.save(task);
    }

    @GetMapping
    public List<TaskAssignment> getAll() {
        return service.getAll();
    }
}
