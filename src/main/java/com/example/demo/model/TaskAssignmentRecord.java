package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignment_record")
public class TaskAssignmentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long taskId;

    @Column(nullable = false)
    private Long volunteerId;

    private LocalDateTime assignedAt;

    @Column(nullable = false)
    private String status; // ACTIVE / COMPLETED / CANCELLED

    private String notes;

    public TaskAssignmentRecord() {}

    public TaskAssignmentRecord(Long taskId, Long volunteerId, String notes) {
        this.taskId = taskId;
        this.volunteerId = volunteerId;
        this.notes = notes;
        this.status = "ACTIVE";
    }

    @PrePersist
    public void prePersist() {
        this.assignedAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "ACTIVE";
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public Long getVolunteerId() { return volunteerId; }
    public void setVolunteerId(Long volunteerId) { this.volunteerId = volunteerId; }

    public LocalDateTime getAssignedAt() { return assignedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
