package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evaluationService;

    public AssignmentEvaluationController(
            AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping
    public AssignmentEvaluationRecord submit(
            @RequestBody AssignmentEvaluationRecord evaluation) {
        return evaluationService.evaluateAssignment(evaluation);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(
            @PathVariable Long assignmentId) {
        return evaluationService.getEvaluationsByAssignment(assignmentId);
    }

    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return evaluationService.getAllEvaluations();
    }
}
