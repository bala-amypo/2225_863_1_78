package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRecordController {

    private final TaskRecordService taskRecordService;

    public TaskRecordController(TaskRecordService taskRecordService) {
        this.taskRecordService = taskRecordService;
    }

    @PostMapping
    public TaskRecord createTask(@RequestBody TaskRecord task) {
        return taskRecordService.createTask(task);
    }

    @GetMapping
    public List<TaskRecord> getAllTasks() {
        return taskRecordService.getAllTasks();
    }

    @GetMapping("/{taskCode}")
    public TaskRecord getTaskByCode(@PathVariable String taskCode) {
        return taskRecordService.getTaskByTaskCode(taskCode);
    }

    @GetMapping("/status/{status}")
    public List<TaskRecord> getTasksByStatus(@PathVariable String status) {
        return taskRecordService.getTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public TaskRecord updateTask(@PathVariable Long id, @RequestBody TaskRecord task) {
        return taskRecordService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskRecordService.deleteTask(id);
        return "Task deleted successfully";
    }
}
