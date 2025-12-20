package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskRecord;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.service.TaskRecordService;

@Service
public class TaskRecordServiceImpl implements TaskRecordService {

    private final TaskRecordRepository taskRecordRepository;

    public TaskRecordServiceImpl(TaskRecordRepository taskRecordRepository) {
        this.taskRecordRepository = taskRecordRepository;
    }

    @Override
    public TaskRecord createTask(TaskRecord task) {

        if (task.getRequiredSkill() == null || task.getRequiredSkill().isBlank()) {
            throw new BadRequestException("Required skill must not be null");
        }

        if (task.getRequiredSkillLevel() == null || task.getRequiredSkillLevel().isBlank()) {
            throw new BadRequestException("Required skill level must not be null");
        }

        // PDF RULE
        task.setStatus("OPEN");

        return taskRecordRepository.save(task);
    }

    @Override
    public TaskRecord getTaskById(Long id) {
        return taskRecordRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
}
