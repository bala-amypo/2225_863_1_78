package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskCode;
    private String taskName;
    private String requiredSkill;
    private String requiredSkillLevel;
    private String status;

    public TaskRecord() {
    }

    public TaskRecord(String taskCode, String taskName, String requiredSkill, String requiredSkillLevel, String status) {
        this.taskCode = taskCode;
        this.taskName = taskName;
        this.requiredSkill = requiredSkill;
        this.requiredSkillLevel = requiredSkillLevel;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTaskName() {
        return taskName;
    }
 
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
 
    public String getRequiredSkill() {
        return requiredSkill;
    }
 
    public void setRequiredSkill(String requiredSkill) {
        this.requiredSkill = requiredSkill;
    }
 
    public String getRequiredSkillLevel() {
        return requiredSkillLevel;
    }
 
    public void setRequiredSkillLevel(String requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }
 
    public String getStatus() {
        return status;
    }
 
    public void setStatus(String status) {
        this.status = status;
    }
}
