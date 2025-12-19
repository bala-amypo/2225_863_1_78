package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task-records")
public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    @PostMapping
    public TaskRecord save(@RequestBody TaskRecord record) {
        return service.save(record);
    }

    @GetMapping
    public List<TaskRecord> getAll() {
        return service.getAll();
    }
}
