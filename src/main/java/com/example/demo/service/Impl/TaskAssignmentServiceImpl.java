package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignment;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repository;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository repository) {
        this.repository = repository;
    }

    public TaskAssignment save(TaskAssignment task) {
        return repository.save(task);
    }

    public List<TaskAssignment> getAll() {
        return repository.findAll();
    }
}
