package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import java.util.*;

public class TaskRecordServiceImpl {

    private final TaskRecordRepository repo;

    public TaskRecordServiceImpl(TaskRecordRepository repo) {
        this.repo = repo;
    }

    public TaskRecord createTask(TaskRecord t) {
        if (t.getStatus() == null) t.setStatus("OPEN");
        return repo.save(t);
    }

    public TaskRecord updateTask(Long id, TaskRecord u) {
        TaskRecord e = repo.findById(id).orElseThrow();
        e.setTaskName(u.getTaskName());
        e.setRequiredSkill(u.getRequiredSkill());
        e.setRequiredSkillLevel(u.getRequiredSkillLevel());
        e.setPriority(u.getPriority());
        e.setStatus(u.getStatus());
        return repo.save(e);
    }

    public List<TaskRecord> getOpenTasks() {
        return repo.findByStatus("OPEN");
    }

    public Optional<TaskRecord> getTaskByCode(String code) {
        return repo.findByTaskCode(code);
    }

    public List<TaskRecord> getAllTasks() {
        return repo.findAll();
    }
}
