package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    // POST - create task
    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return service.create(task);
    }

    // GET by id
    @GetMapping("/{id}")
    public TaskRecord get(@PathVariable Long id) {
        return service.get(id);
    }

    // GET all
    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAll();
    }

    // GET open tasks
    @GetMapping("/open")
    public List<TaskRecord> getOpen() {
        return service.getOpenTasks();
    }

    // ✅ ONLY ONE PUT — updates ALL fields
    @PutMapping("/{id}")
    public TaskRecord update(
            @PathVariable Long id,
            @RequestBody TaskRecord updatedTask) {

        return service.update(id, updatedTask);
    }
}
