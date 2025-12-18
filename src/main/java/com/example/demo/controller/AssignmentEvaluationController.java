package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService assignmentEvaluationService;

    public AssignmentEvaluationController(AssignmentEvaluationService assignmentEvaluationService) {
        this.assignmentEvaluationService = assignmentEvaluationService;
    }

    @PostMapping
    public AssignmentEvaluationRecord addEvaluation(
            @RequestBody AssignmentEvaluationRecord evaluation) {
        return assignmentEvaluationService.addEvaluation(evaluation);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getEvaluationsByAssignment(
            @PathVariable Long assignmentId) {
        return assignmentEvaluationService.getEvaluationsByAssignmentId(assignmentId);
    }
}
