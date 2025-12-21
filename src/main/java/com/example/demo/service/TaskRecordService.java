package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TaskRecord;

public interface TaskRecordService {

    TaskRecord create(TaskRecord task);

    TaskRecord update(Long id, TaskRecord task);

    TaskRecord updateStatus(Long id, String status);

    TaskRecord get(Long id);

    List<TaskRecord> getOpenTasks();

    List<TaskRecord> getAll();
}
