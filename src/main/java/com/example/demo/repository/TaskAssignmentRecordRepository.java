package com.example.demo.repository;

import com.example.demo.model.TaskAssignmentRecord;
import java.util.*;

public interface TaskAssignmentRecordRepository {
    boolean existsByTaskIdAndStatus(Long id,String status);
    List<TaskAssignmentRecord> findByTaskId(Long id);
    List<TaskAssignmentRecord> findByVolunteerId(Long id);
    List<TaskAssignmentRecord> findAll();
    Optional<TaskAssignmentRecord> findById(Long id);
    TaskAssignmentRecord save(TaskAssignmentRecord r);
}
