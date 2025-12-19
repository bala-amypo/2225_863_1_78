package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignments")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private String assignmentStatus;

    public TaskAssignmentRecord() {
    }

    public TaskAssignmentRecord(Long taskId, Long volunteerId, String assignmentStatus) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.assignmentStatus = assignmentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaskId() {
        return taskId;
    }
 
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
 
    public Long getVolunteerId() {
        return volunteerId;
    }
 
    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }
 
    public String getAssignmentStatus() {
        return assignmentStatus;
    }
 
    public void setAssignmentStatus(String assignmentStatus) {
        this.assignmentStatus = assignmentStatus;
    }
}
