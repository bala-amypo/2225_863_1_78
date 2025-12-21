package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public TaskRecord create(TaskRecord task) {
        return repo.save(task);
    }

    @Override
    public TaskRecord get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Task not found"));
    }

    @Override
    public List<TaskRecord> getAll() {
        return repo.findAll();
    }

    @Override
    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    // ✅ FULL UPDATE LOGIC
    @Override
    public TaskRecord update(Long id, TaskRecord updatedTask) {

        TaskRecord existing = repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Task not found"));

        existing.setTaskCode(updatedTask.getTaskCode());
        existing.setTaskName(updatedTask.getTaskName());
        existing.setRequiredSkill(updatedTask.getRequiredSkill());
        existing.setRequiredSkillLevel(updatedTask.getRequiredSkillLevel());
        existing.setStatus(updatedTask.getStatus());

        return repo.save(existing);
    }
}
