package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TaskAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }
}
