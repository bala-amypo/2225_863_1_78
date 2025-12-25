package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.TaskAssignmentRecord;
import com.example.demo.model.TaskRecord;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.TaskAssignmentRecordRepository;
import com.example.demo.repository.TaskRecordRepository;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.TaskAssignmentService;
import com.example.demo.util.SkillLevelUtil;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskAssignmentServiceImpl implements TaskAssignmentService {
    
    private final TaskAssignmentRecordRepository assignmentRepository;
    private final TaskRecordRepository taskRepository;
    private final VolunteerProfileRepository volunteerRepository;
    private final VolunteerSkillRecordRepository skillRepository;
    
    public TaskAssignmentServiceImpl(TaskAssignmentRecordRepository assignmentRepository,
                                   TaskRecordRepository taskRepository,
                                   VolunteerProfileRepository volunteerRepository,
                                   VolunteerSkillRecordRepository skillRepository) {
        this.assignmentRepository = assignmentRepository;
        this.taskRepository = taskRepository;
        this.volunteerRepository = volunteerRepository;
        this.skillRepository = skillRepository;
    }
    
    @Override
    public TaskAssignmentRecord assignTask(Long taskId) {
        if (assignmentRepository.existsByTaskIdAndStatus(taskId, "ACTIVE")) {
            throw new BadRequestException("Task already has an ACTIVE assignment");
        }
        
        TaskRecord task = taskRepository.findById(taskId)
            .orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        
        List<VolunteerProfile> availableVolunteers = volunteerRepository.findByAvailabilityStatus("AVAILABLE");
        
        if (availableVolunteers.isEmpty()) {
            throw new BadRequestException("No AVAILABLE volunteers found");
        }
        
        for (VolunteerProfile volunteer : availableVolunteers) {
            List<VolunteerSkillRecord> skills = skillRepository.findByVolunteerId(volunteer.getId());
            
            for (VolunteerSkillRecord skill : skills) {
                if (skill.getSkillName().equals(task.getRequiredSkill()) &&
                    SkillLevelUtil.isSkillLevelSufficient(skill.getSkillLevel(), task.getRequiredSkillLevel())) {
                    
                    TaskAssignmentRecord assignment = new TaskAssignmentRecord(taskId, volunteer.getId(), "ACTIVE");
                    assignment = assignmentRepository.save(assignment);
                    
                    task.setStatus("ACTIVE");
                    taskRepository.save(task);
                    
                    return assignment;
                }
            }
        }
        
        throw new BadRequestException("No volunteer with sufficient required skill level found");
    }
    
    @Override
    public List<TaskAssignmentRecord> getAssignmentsByTask(Long taskId) {
        return assignmentRepository.findByTaskId(taskId);
    }
    
    @Override
    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long volunteerId) {
        return assignmentRepository.findByVolunteerId(volunteerId);
    }
    
    @Override
    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignmentRepository.findAll();
    }
}