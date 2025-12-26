package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    // POST /api/evaluations
    @PostMapping
    public AssignmentEvaluationRecord create(
            @RequestBody AssignmentEvaluationRecord record) {
        return service.evaluateAssignment(record);
    }

    // GET /api/evaluations
    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return service.getAllEvaluations();
    }

    // GET /api/evaluations/assignment/{assignmentId}
    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> getByAssignment(
            @PathVariable Long assignmentId) {
        return service.getEvaluationsByAssignment(assignmentId);
    }
}
