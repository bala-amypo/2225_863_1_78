package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;

@Service
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

        TaskAssignmentRecord assignment =
                assignmentRepo.findById(evaluation.getAssignmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found"));

        if (!"COMPLETED".equals(assignment.getStatus())) {
            throw new BadRequestException(
                    "Evaluation allowed only for COMPLETED assignment");
        }

        return evaluationRepo.save(evaluation);
    }
}
