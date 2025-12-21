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

    // POST /api/tasks - Create task
    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return service.create(task);
    }

    // ✅ PUT /api/tasks/{id} - Update task
    @PutMapping("/{id}")
    public TaskRecord update(
            @PathVariable Long id,
            @RequestBody TaskRecord task) {

        return service.update(id, task);
    }

    // GET /api/tasks/{id} - Get task
    @GetMapping("/{id}")
    public TaskRecord getById(@PathVariable Long id) {
        return service.get(id);
    }

    // GET /api/tasks/open - Get open tasks
    @GetMapping("/open")
    public List<TaskRecord> openTasks() {
        return service.getOpenTasks();
    }

    // GET /api/tasks - List all
    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAll();
    }
}
