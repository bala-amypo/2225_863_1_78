package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService taskAssignmentService;

    public TaskAssignmentController(TaskAssignmentService taskAssignmentService) {
        this.taskAssignmentService = taskAssignmentService;
    }

    @PostMapping
    public TaskAssignmentRecord assignTask(@RequestBody TaskAssignmentRecord assignment) {
        return taskAssignmentService.assignTask(assignment);
    }

    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getAssignmentsByTask(@PathVariable Long taskId) {
        return taskAssignmentService.getAssignmentsByTaskId(taskId);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(@PathVariable Long volunteerId) {
        return taskAssignmentService.getAssignmentsByVolunteerId(volunteerId);
    }

    @PutMapping("/{id}/complete")
    public TaskAssignmentRecord completeAssignment(@PathVariable Long id) {
        return taskAssignmentService.completeAssignment(id);
    }
}
