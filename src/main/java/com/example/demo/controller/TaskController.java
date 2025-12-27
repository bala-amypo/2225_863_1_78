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

    
    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return service.createTask(task);
    }

   
    @PutMapping("/{id}")
    public TaskRecord updateTask(
            @PathVariable Long id,
            @RequestBody TaskRecord updatedTask) {

        return service.updateTask(id, updatedTask);
    }

   
    @GetMapping("/open")
    public List<TaskRecord> getOpenTasks() {
        return service.getOpenTasks();
    }

   
    @GetMapping("/{id}")
    public TaskRecord getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    
    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return service.getAllTasks();
    }
}
