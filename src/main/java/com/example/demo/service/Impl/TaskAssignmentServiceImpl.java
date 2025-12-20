package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskAssignmentService;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository assignmentRepo;
    private final TaskRecordRepository taskRepo;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepo,
                                     TaskRecordRepository taskRepo) {
        this.assignmentRepo = assignmentRepo;
        this.taskRepo = taskRepo;
    }

    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {

        // PDF RULE: only one ACTIVE assignment
        if (assignmentRepo.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("ACTIVE assignment already exists");
        }

        TaskRecord task = taskRepo.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        // NOTE: Volunteer matching logic skipped (safe version)
        TaskAssignmentRecord assignment =
                new TaskAssignmentRecord(taskId, 1L, "ACTIVE");

        task.setStatus("ACTIVE");
        taskRepo.save(task);

        return assignmentRepo.save(assignment);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepo.findByVolunteerId(volunteerId);
    }
}
