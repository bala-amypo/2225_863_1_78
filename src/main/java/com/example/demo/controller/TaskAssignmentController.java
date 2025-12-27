package com.example.demo.controller;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

   
    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assign(@PathVariable Long taskId) {
        return service.assignTask(taskId);
    }

    
    @PutMapping("/{id}/status")
    @Transactional
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        TaskAssignmentRecord record = service.getAllAssignments()
                .stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("Assignment not found"));

        // JPA dirty checking will persist this
        record.setStatus(status);

        return record;
    }

    // GET /api/assignments/volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> getByVolunteer(
            @PathVariable Long volunteerId) {
        return service.getAssignmentsByVolunteer(volunteerId);
    }

    // GET /api/assignments/task/{taskId}
    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> getByTask(
            @PathVariable Long taskId) {
        return service.getAssignmentsByTask(taskId);
    }

    // GET /api/assignments
    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return service.getAllAssignments();
    }
}
