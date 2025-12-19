package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentEvaluationServiceImpl implements AssignmentEvaluationService {

    private final AssignmentEvaluationRecordRepository repository;

    public AssignmentEvaluationServiceImpl(AssignmentEvaluationRecordRepository repository) {
        this.repository = repository;
    }

    public AssignmentEvaluation save(AssignmentEvaluation evaluation) {
        return repository.save(evaluation);
    }

    public List<AssignmentEvaluation> getAll() {
        return repository.findAll();
    }
}
