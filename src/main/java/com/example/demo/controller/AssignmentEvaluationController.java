package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;

public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    public AssignmentEvaluationRecord evaluate(EvaluationRequest request) {
        AssignmentEvaluationRecord record = new AssignmentEvaluationRecord();
        record.setAssignmentId(request.getAssignmentId());
        record.setRating(request.getRating());
        record.setFeedback(request.getFeedback());
        return service.evaluateAssignment(record);
    }
}
