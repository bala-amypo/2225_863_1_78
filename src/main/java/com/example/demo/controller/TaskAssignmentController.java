package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    private final TaskAssignmentRecordRepository repo;

    public TaskAssignmentController(TaskAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    // POST /assign/{taskId} - Auto assign (simple version)
    @PostMapping("/assign/{taskId}")
    public TaskAssignmentRecord assign(@PathVariable Long taskId) {
        TaskAssignmentRecord a = new TaskAssignmentRecord();
        a.setTaskId(taskId);
        a.setVolunteerId(1L); // dummy for CRUD level
        return repo.save(a);
    }

    // PUT /{id}/status - Update status
    @PutMapping("/{id}/status")
    public TaskAssignmentRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        TaskAssignmentRecord a = repo.findById(id).orElseThrow();
        a.setStatus(status);
        return repo.save(a);
    }

    // GET /volunteer/{volunteerId}
    @GetMapping("/volunteer/{volunteerId}")
    public List<TaskAssignmentRecord> byVolunteer(@PathVariable Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    // GET /task/{taskId}
    @GetMapping("/task/{taskId}")
    public List<TaskAssignmentRecord> byTask(@PathVariable Long taskId) {
        return repo.findByTaskId(taskId);
    }

    // GET / - List all
    @GetMapping
    public List<TaskAssignmentRecord> getAll() {
        return repo.findAll();
    }
}
