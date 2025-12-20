package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

import java.util.List;

public class AssignmentEvaluationServiceImpl
        implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evaluationRepo;
    private final TaskAssignmentRecordRepository assignmentRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository evaluationRepo,
            TaskAssignmentRecordRepository assignmentRepo) {
        this.evaluationRepo = evaluationRepo;
        this.assignmentRepo = assignmentRepo;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        if (evaluation.getAssignmentId() == null) {
            throw new BadRequestException("Assignment ID required");
        }

        assignmentRepo.findById(evaluation.getAssignmentId())
                .orElseThrow(() ->
                        new BadRequestException("Invalid assignment"));

        return evaluationRepo.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {
        return evaluationRepo.findByAssignmentId(assignmentId);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return evaluationRepo.findAll();
    }
}
