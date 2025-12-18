package com.example.demo.service.impl;

import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository repository;

    public TaskRecordServiceImpl(TaskRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {
        if (repository.findByTaskCode(task.getTaskCode()) != null) {
            throw new RuntimeException("Task code already exists");
        }
        return repository.save(task);
    }

    @Override
    public List<TaskRecord> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public TaskRecord getTaskByTaskCode(String taskCode) {
        TaskRecord task = repository.findByTaskCode(taskCode);
        if (task == null) {
            throw new RuntimeException("Task not found");
        }
        return task;
    }

    @Override
    public List<TaskRecord> getTasksByStatus(String status) {
        return repository.findByStatus(status);
    }

    @Override
    public TaskRecord updateTask(Long id, TaskRecord task) {
        TaskRecord existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        existing.setTaskName(task.getTaskName());
        existing.setPriority(task.getPriority());
        existing.setStatus(task.getStatus());

        return repository.save(existing);
    }

    @Override
    public void deleteTask(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Task not found");
        }
        repository.deleteById(id);
    }
}
