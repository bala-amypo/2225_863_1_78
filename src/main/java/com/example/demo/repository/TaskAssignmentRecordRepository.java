package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.TaskAssignmentRecord;

public interface TaskAssignmentRecordRepository
        extends JpaRepository<TaskAssignmentRecord, Long> {

    List<TaskAssignmentRecord> findByVolunteerId(Long volunteerId);
    List<TaskAssignmentRecord> findByTaskId(Long taskId);
}
