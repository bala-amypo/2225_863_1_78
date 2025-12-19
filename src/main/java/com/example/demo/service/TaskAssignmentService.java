package com.example.demo.service;

import com.example.demo.model.TaskAssignment;
import java.util.List;

public interface TaskAssignmentService {
    TaskAssignment save(TaskAssignment task);
    List<TaskAssignment> getAll();
}
