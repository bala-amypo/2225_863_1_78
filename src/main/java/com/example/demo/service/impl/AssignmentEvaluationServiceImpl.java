package com.example.demo.service.impl;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.*;
import java.util.*;

public class AssignmentEvaluationServiceImpl {

    private final AssignmentEvaluationRecordRepository evalRepo;
    private final TaskAssignmentRecordRepository assignRepo;

    public AssignmentEvaluationServiceImpl(
            AssignmentEvaluationRecordRepository e,
            TaskAssignmentRecordRepository a) {
        this.evalRepo = e;
        this.assignRepo = a;
    }

    public AssignmentEvaluationRecord evaluateAssignment(AssignmentEvaluationRecord e) {
        assignRepo.findById(e.getAssignmentId()).orElseThrow();
        return evalRepo.save(e);
    }

    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(Long id) {
        return evalRepo.findByAssignmentId(id);
    }
}
