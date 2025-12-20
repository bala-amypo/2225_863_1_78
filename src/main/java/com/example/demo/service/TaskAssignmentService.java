package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentService {

    TaskAssignmentRecord assign(Long taskId);

    TaskAssignmentRecord updateStatus(Long id, String status);

    List<TaskAssignmentRecord> getByVolunteer(Long volunteerId);

    List<TaskAssignmentRecord> getByTask(Long taskId);

    List<TaskAssignmentRecord> getAll();
}
