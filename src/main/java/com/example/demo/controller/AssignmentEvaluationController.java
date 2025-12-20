package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;

@RestController
@RequestMapping("/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evaluationService;

    public AssignmentEvaluationController(
            AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public ResponseEntity<AssignmentEvaluationRecord> evaluate(
            @RequestBody AssignmentEvaluationRecord evaluation) {

        return ResponseEntity.ok(
                evaluationService.evaluateAssignment(evaluation));
    }
}
