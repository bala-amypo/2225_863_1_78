package com.example.demo.service;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.List;

public interface TaskAssignmentService {

    TaskAssignmentRecord assignTask(TaskAssignmentRecord assignment);

    List<TaskAssignmentRecord> getAssignmentsByTaskId(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteerId(Long volunteerId);

    TaskAssignmentRecord completeAssignment(Long id);
}
