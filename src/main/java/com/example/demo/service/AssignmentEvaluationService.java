package com.example.demo.service;

import java.util.List;
import com.example.demo.model.AssignmentEvaluationRecord;

public interface AssignmentEvaluationService {

    AssignmentEvaluationRecord submit(AssignmentEvaluationRecord evaluation);

    List<AssignmentEvaluationRecord> getByAssignment(Long assignmentId);

    List<AssignmentEvaluationRecord> getAll();
}
