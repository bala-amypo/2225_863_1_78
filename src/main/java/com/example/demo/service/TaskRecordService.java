package com.example.demo.service;

import com.example.demo.model.TaskRecord;
import java.util.List;

public interface TaskRecordService {

    TaskRecord createTask(TaskRecord task);

    List<TaskRecord> getAllTasks();

    TaskRecord getTaskByTaskCode(String taskCode);

    List<TaskRecord> getTasksByStatus(String status);

    TaskRecord updateTask(Long id, TaskRecord task);

    void deleteTask(Long id);
}
