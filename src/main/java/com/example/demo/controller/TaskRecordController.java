package com.example.demo.controller;

import com.example.demo.model.TaskRecord;
import com.example.demo.service.TaskRecordService;

import java.util.List;

public class TaskRecordController {

    private final TaskRecordService service;

    public TaskRecordController(TaskRecordService service) {
        this.service = service;
    }

    public TaskRecord create(TaskRecord task) {
        return service.createTask(task);
    }

    public List<TaskRecord> getOpenTasks() {
        return service.getOpenTasks();
    }
}
