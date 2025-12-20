package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.AssignmentEvaluationRecord;
import com.example.demo.repository.AssignmentEvaluationRecordRepository;

@RestController
@RequestMapping("/api/evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationRecordRepository repo;

    public AssignmentEvaluationController(AssignmentEvaluationRecordRepository repo) {
        this.repo = repo;
    }

    // POST / - Submit evaluation
    @PostMapping
    public AssignmentEvaluationRecord submit(
            @RequestBody AssignmentEvaluationRecord eval) {
        return repo.save(eval);
    }

    // GET /assignment/{assignmentId}
    @GetMapping("/assignment/{assignmentId}")
    public List<AssignmentEvaluationRecord> byAssignment(
            @PathVariable Long assignmentId) {
        return repo.findByAssignmentId(assignmentId);
    }

    // GET / - List all
    @GetMapping
    public List<AssignmentEvaluationRecord> getAll() {
        return repo.findAll();
    }
}
