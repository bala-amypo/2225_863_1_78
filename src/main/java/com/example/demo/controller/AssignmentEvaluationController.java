package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class AssignmentEvaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String remarks;
    private int score;

    public AssignmentEvaluation() {
    }

    public AssignmentEvaluation(Long id, String remarks, int score) {
        this.id = id;
        this.remarks = remarks;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
