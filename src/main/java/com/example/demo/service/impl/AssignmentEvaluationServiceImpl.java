package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository evaluationRepository;
    private final TaskAssignmentRecordRepository assignmentRepository;

    
    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository evaluationRepository,
            TaskAssignmentRecordRepository assignmentRepository) {

        this.evaluationRepository = evaluationRepository;
        this.assignmentRepository = assignmentRepository;
    }

    @Override
    public AssignmentEvaluationRecord evaluateAssignment(
            AssignmentEvaluationRecord evaluation) {

        Long assignmentId = evaluation.getAssignmentId();

        TaskAssignmentRecord assignment = assignmentRepository
                .findById(assignmentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Assignment not found"));

        return evaluationRepository.save(evaluation);
    }

    @Override
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            Long assignmentId) {

        return evaluationRepository.findByAssignmentId(assignmentId);
    }

    @Override
    public List<AssignmentEvaluationRecord> getAllEvaluations() {
        return evaluationRepository.findAll();
    }
}
