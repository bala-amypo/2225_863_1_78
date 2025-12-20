package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

@Service
public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public AssignmentEvaluationRecord submit(
            AssignmentEvaluationRecord evaluation) {
        return repo.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getByAssignment(Long assignmentId) {
        return repo.findByAssignmentId(assignmentId);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAll() {
        return repo.findAll();
    }
}
