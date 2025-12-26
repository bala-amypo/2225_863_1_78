package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskRecordService service;

    public TaskController(TaskRecordService service) {
        this.service = service;
    }

    // POST /api/tasks  → Create task
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

    // PUT /api/tasks/{id} → Update FULL task (ONLY ONE PUT)
    @PutMapping("/{id}")
    public TaskRecord updateTask(
            @PathVariable Long id,
            @RequestBody TaskRecord updatedTask) {

        return service.updateTask(id, updatedTask);
    }

    // GET /api/tasks/open → List open tasks
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return service.getOpenTasks();
    }

    // GET /api/tasks/{id} → Get task by id
    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    // GET /api/tasks → List all tasks
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }
}
