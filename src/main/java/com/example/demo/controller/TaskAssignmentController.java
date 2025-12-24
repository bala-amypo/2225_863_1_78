package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    
    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assign(@PathVariable Long taskId) {
        return service.assign(taskId);
    }

   
    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }

    
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(
            @PathVariable Long volunteerId) {
        return service.getByVolunteer(volunteerId);
    }

    
    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> byTask(
            @PathVariable Long taskId) {
        return service.getByTask(taskId);
    }

   
    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return service.getAll();
    }
}