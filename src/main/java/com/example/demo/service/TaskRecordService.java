package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TaskRecord;

public interface TaskRecordService {

    TaskRecord create(TaskRecord task);

    TaskRecord get(Long id);

    List<TaskRecord> getAll();

    List<TaskRecord> getOpenTasks();

    TaskRecord update(Long id, TaskRecord updatedTask);
}
