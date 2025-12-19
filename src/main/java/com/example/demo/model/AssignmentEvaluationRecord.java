package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "assignment_evaluations")
public class AssignmentEvaluationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long assignmentId;
    private int rating;
    private String feedback;

    public AssignmentEvaluationRecord() {
    }

    public AssignmentEvaluationRecord(Long assignmentId, int rating, String feedback) {
        this.assignmentId = assignmentId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getAssignmentId() {
        return assignmentId;
    }
 
    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }
 
    public int getRating() {
        return rating;
    }
 
    public void setRating(int rating) {
        this.rating = rating;
    }
 
    public String getFeedback() {
        return feedback;
    }
 
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
