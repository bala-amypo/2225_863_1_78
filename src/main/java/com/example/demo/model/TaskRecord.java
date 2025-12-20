package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "task_record",
    uniqueConstraints = @UniqueConstraint(columnNames = "taskCode")
)
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String taskCode;

    private String taskName;

    @Column(nullable = false)
    private String requiredSkill;

    @Column(nullable = false)
    private String requiredSkillLevel;

    private String priority; // LOW / MEDIUM / HIGH

    @Column(nullable = false)
    private String status; // OPEN / CLOSED

    private LocalDateTime createdAt;

    public TaskRecord() {}

    public TaskRecord(String taskCode, String taskName, String requiredSkill,
                      String requiredSkillLevel, String priority) {
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.requiredSkill = requiredSkill;
        this.requiredSkillLevel = requiredSkillLevel;
        this.priority = priority;
        this.status = "OPEN";
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "OPEN";
        }
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getTaskCode() { return taskCode; }
    public void setTaskCode(String taskCode) { this.taskCode = taskCode; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getRequiredSkill() { return requiredSkill; }
    public void setRequiredSkill(String requiredSkill) { this.requiredSkill = requiredSkill; }

    public String getRequiredSkillLevel() { return requiredSkillLevel; }
    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
