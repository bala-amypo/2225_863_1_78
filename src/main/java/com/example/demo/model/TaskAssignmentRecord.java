package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task_assignment_records")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private Long volunteerId;

    @Column(nullable = false)
    private String status;

    
    public TaskAssignmentRecord() {
    }

    
    public TaskAssignmentRecord(Long taskId, Long volunteerId, String status) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getTaskId() {
        return taskId;
    }

    public Long getVolunteerId() {
        return volunteerId;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
