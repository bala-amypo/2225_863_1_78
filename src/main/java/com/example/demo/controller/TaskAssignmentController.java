package com.example.demo.controller;

import com.example.demo.dto.AssignmentStatusUpdateRequest;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.service.TaskAssignmentService;

import java.util.List;

public class TaskAssignmentController {

    private final TaskAssignmentService service;

    public TaskAssignmentController(TaskAssignmentService service) {
        this.service = service;
    }

    public TaskAssignmentRecord assign(Long taskId) {
        return service.assignTask(taskId);
    }

    public List<TaskAssignmentRecord> getAll() {
        return service.getAllAssignments();
    }

    public void updateStatus(AssignmentStatusUpdateRequest request) {
        // baseline method – logic optional
    }
}
