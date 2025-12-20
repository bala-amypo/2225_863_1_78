package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordRepository repo;

    public TaskRecordController(TaskRecordRepository repo) {
        this.repo = repo;
    }

    // POST / - Create task
    @PostMapping
    public TaskRecord create(@RequestBody TaskRecord task) {
        return repo.save(task);
    }

    // PUT /{id} - Update task
    @PutMapping("/{id}")
    public TaskRecord update(@PathVariable Long id, @RequestBody TaskRecord updated) {
        TaskRecord t = repo.findById(id).orElseThrow();
        t.setTaskName(updated.getTaskName());
        t.setRequiredSkill(updated.getRequiredSkill());
        t.setRequiredSkillLevel(updated.getRequiredSkillLevel());
        return repo.save(t);
    }

    // GET /open - List open tasks
    @GetMapping("/open")
    public List<TaskRecord> openTasks() {
        return repo.findByStatus("OPEN");
    }

    // GET /{id} - Get task
    @GetMapping("/{id}")
    public TaskRecord getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // GET / - List all
    @GetMapping
    public List<TaskRecord> getAll() {
        return repo.findAll();
    }
}
