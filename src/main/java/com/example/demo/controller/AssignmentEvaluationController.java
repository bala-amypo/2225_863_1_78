package com.example.demo.controller;

import com.example.demo.model.AssignmentEvaluation;
import com.example.demo.service.AssignmentEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment-evaluations")
public class AssignmentEvaluationController {

    private final AssignmentEvaluationService service;

    public AssignmentEvaluationController(AssignmentEvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public AssignmentEvaluation save(@RequestBody AssignmentEvaluation evaluation) {
        return service.save(evaluation);
    }

    @GetMapping
    public List<AssignmentEvaluation> getAll() {
        return service.getAll();
    }
}
