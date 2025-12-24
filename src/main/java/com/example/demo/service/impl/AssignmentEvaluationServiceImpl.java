package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.repository.*;
import com.example.demo.model.AssignmentEvaluationRecord;

@Service
public class AssignmentEvaluationServiceImpl {

    private final AssignmentEvaluationRecordRepository repo;
    private final TaskAssignmentRecordRepository taskAssignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repo,
            TaskAssignmentRecordRepository taskAssignmentRepo) {

        this.repo = repo;
        this.taskAssignmentRepo = taskAssignmentRepo;
    }

    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord r) {
        return repo.save(r);
    }
}
