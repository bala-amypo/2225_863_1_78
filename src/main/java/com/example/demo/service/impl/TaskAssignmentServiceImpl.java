package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.exception.BadRequestException;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {

    private final TaskAssignmentRecordRepository repo;

    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository repo) {
        this.repo = repo;
    }

    
    @Override
    public TaskAssignmentRecord assign(Long taskId) {

        TaskAssignmentRecord record = new TaskAssignmentRecord();
        record.setTaskId(taskId);
        record.setVolunteerId(1L); 

        return repo.save(record);
    }

    
    @Override
    public TaskAssignmentRecord updateStatus(Long id, String status) {

        TaskAssignmentRecord existing = repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Assignment not found"));

        existing.setStatus(status);

        return repo.save(existing); // UPDATE
    }

    @Override
    public List<TaskAssignmentRecord> getByVolunteer(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<TaskAssignmentRecord> getByTask(Long taskId) {
        return repo.findByTaskId(taskId);
    }

    @Override
    public List<TaskAssignmentRecord> getAll() {
        return repo.findAll();
    }
}
