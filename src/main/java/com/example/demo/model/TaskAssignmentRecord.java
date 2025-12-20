package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignment_records")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private Long volunteerId;
    private LocalDateTime assignedAt;
    private String status; // ACTIVE / COMPLETED / CANCELLED
    private String notes;

    public TaskAssignmentRecord() {
        this.status = "ACTIVE";
        this.assignedAt = LocalDateTime.now();
    }

    public TaskAssignmentRecord(Long taskId, Long volunteerId, String notes) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.notes = notes;
        this.status = "ACTIVE";
        this.assignedAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public LocalDateTime getAssignedAt() { return assignedAt; }
    public void setAssignedAt(LocalDateTime assignedAt) { this.assignedAt = assignedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
