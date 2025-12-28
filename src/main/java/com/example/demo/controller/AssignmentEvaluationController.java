package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
@SecurityRequirement(name = "bearerAuth")

public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluationRecord create(
            @RequestBody AssignmentEvaluationRecord record) {
        return service.evaluateAssignment(record);
    }

    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(
            @PathVariable Long assignmentId) {
        return service.getEvaluationsByAssignment(assignmentId);
    }

    // ✅ NEW: GET all evaluations
    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return service.getAll();
    }
}
