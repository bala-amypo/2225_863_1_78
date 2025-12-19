package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluation;
import java.util.List;

public interface AssignmentEvaluationService {
    AssignmentEvaluation save(AssignmentEvaluation evaluation);
    List<AssignmentEvaluation> getAll();
}
