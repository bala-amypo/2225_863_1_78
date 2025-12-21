package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    // POST /api/tasks
    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return service.create(task);
    }

    // ✅ PUT /api/tasks/{id}
    @PutMapping("/{id}")
    public TaskRecord update(
            @PathVariable Long id,
            @RequestBody TaskRecord task) {

        return service.update(id, task);
    }

    // ✅ PUT /api/tasks/{id}/status
    @PutMapping("/{id}/status")
    public TaskRecord updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateStatus(id, status);
    }

    // GET /api/tasks/{id}
    @GetMapping("/{id}")
    public TaskRecord get(@PathVariable Long id) {
        return service.get(id);
    }

    // GET /api/tasks/open
    @GetMapping("/open")
    public List<TaskRecord> openTasks() {
        return service.getOpenTasks();
    }

    // GET /api/tasks
    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAll();
    }
}
