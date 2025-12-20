package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@Tag(name = "Assignment Evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService evaluationService;

    // ✅ Constructor injection
    public AssignmentEvaluationController(
            AssignmentEvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @Operation(summary = "Submit evaluation for an assignment")
    @PostMapping
    public AssignmentEvaluationRecord submitEvaluation(
            @RequestBody AssignmentEvaluationRecord evaluation) {

        return evaluationService.evaluateAssignment(evaluation);
    }

    @Operation(summary = "Get evaluations by assignment")
    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(
            @PathVariable Long assignmentId) {

        return evaluationService.getEvaluationsByAssignment(assignmentId);
    }

    @Operation(summary = "Get all evaluations")
    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return evaluationService.getAllEvaluations();
    }
}
