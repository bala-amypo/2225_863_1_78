package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentService {

    void assignTask(Long taskId);

    List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId);
}
