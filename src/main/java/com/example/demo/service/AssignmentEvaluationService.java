package com.example.demo.service;

import com.example.demo.model.AssignmentEvaluationRecord;
import java.util.List;

public interface AssignmentEvaluationService {

    AssignmentEvaluationRecord addEvaluation(AssignmentEvaluationRecord evaluation);

    List<AssignmentEvaluationRecord> getEvaluationsByAssignmentId(Long assignmentId);
}
