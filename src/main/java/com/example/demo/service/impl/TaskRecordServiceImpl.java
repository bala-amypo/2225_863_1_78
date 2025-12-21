package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import com.example.demo.exception.BadRequestException;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    // CREATE
    @Override
    public TaskRecord create(TaskRecord task) {
        return repo.save(task);
    }

    // ✅ UPDATE (CORRECT)
    @Override
    public TaskRecord update(Long id, TaskRecord updated) {

        TaskRecord existing = repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        existing.setTaskName(updated.getTaskName());
        existing.setRequiredSkill(updated.getRequiredSkill());
        existing.setRequiredSkillLevel(updated.getRequiredSkillLevel());

        return repo.save(existing); // UPDATE
    }

    @Override
    public TaskRecord get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Task not found"));
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    @Override
    public List<TaskRecord> getAll() {
        return repo.findAll();
    }
}
