package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.demo.model.AssignmentEvaluationRecord;

public interface AssignmentEvaluationRecordRepository
        extends JpaRepository<AssignmentEvaluationRecord, Long> {

    List<AssignmentEvaluationRecord> findByAssignmentId(Long assignmentId);
}