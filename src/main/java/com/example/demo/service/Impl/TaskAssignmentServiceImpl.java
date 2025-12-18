package com.example.demo.service.impl;

import com.example.demo.model.TaskAssignmentRecord;
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

    @Override
    public TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment) {

        boolean exists = repository.existsByTaskIdAndStatus(
                assignment.getTaskId(), "ACTIVE");

        if (exists) {
            throw new RuntimeException("Task already assigned");
        }
        return repository.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTaskId(Long taskId) {
        return repository.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteerId(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public TaskAssignmentRecord completeAssignment(Long id) {
        TaskAssignmentRecord record = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Assignment not found"));

        record.setStatus("COMPLETED");
        return repository.save(record);
    }
}
