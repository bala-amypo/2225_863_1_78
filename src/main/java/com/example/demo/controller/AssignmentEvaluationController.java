package com.example.demo.controller;

import com.example.demo.dto.EvaluationRequest;
import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {
    
    private final AssignmentEvaluationService evaluationService;
    
    public AssignmentEvaluationController(AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }
    
    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> evaluateAssignment(@RequestBody EvaluationRequest request) {
        AssignmentEvaluationRecord evaluation = new AssignmentEvaluationRecord(
            request.getAssignmentId(), 
            request.getRating(), 
            request.getComments()
        );
        AssignmentEvaluationRecord result = evaluationService.evaluateAssignment(evaluation);
        return ResponseEntity.ok(result);
    }
}