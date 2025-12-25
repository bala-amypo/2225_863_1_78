package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.SkillLevelUtil;
import java.util.*;

public class TaskAssignmentServiceImpl {

    private final TaskAssignmentRecordRepository assignRepo;
    private final TaskRecordRepository taskRepo;
    private final VolunteerProfileRepository profileRepo;
    private final VolunteerSkillRecordRepository skillRepo;

    public TaskAssignmentServiceImpl(
            TaskAssignmentRecordRepository a,
            TaskRecordRepository t,
            VolunteerProfileRepository p,
            VolunteerSkillRecordRepository s) {
        this.assignRepo = a;
        this.taskRepo = t;
        this.profileRepo = p;
        this.skillRepo = s;
    }

    public TaskAssignmentRecord assignTask(Long taskId) {
        TaskRecord task = taskRepo.findById(taskId).orElseThrow();

        if (assignRepo.existsByTaskIdAndStatus(taskId, "ACTIVE"))
            throw new BadRequestException("ACTIVE assignment");

        List<VolunteerProfile> vols =
                profileRepo.findByAvailabilityStatus("AVAILABLE");

        if (vols.isEmpty())
            throw new BadRequestException("No AVAILABLE volunteers");

        for (VolunteerProfile v : vols) {
            for (VolunteerSkillRecord s : skillRepo.findByVolunteerId(v.getId())) {
                if (s.getSkillName().equals(task.getRequiredSkill()) &&
                        SkillLevelUtil.levelRank(s.getSkillLevel()) >=
                                SkillLevelUtil.levelRank(task.getRequiredSkillLevel())) {

                    TaskAssignmentRecord r = new TaskAssignmentRecord();
                    r.setTaskId(taskId);
                    r.setVolunteerId(v.getId());
                    taskRepo.save(task);
                    return assignRepo.save(r);
                }
            }
        }
        throw new BadRequestException("required skill level");
    }

    public List<TaskAssignmentRecord> getAssignmentsByTask(Long id) {
        return assignRepo.findByTaskId(id);
    }

    public List<TaskAssignmentRecord> getAssignmentsByVolunteer(Long id) {
        return assignRepo.findByVolunteerId(id);
    }

    public List<TaskAssignmentRecord> getAllAssignments() {
        return assignRepo.findAll();
    }
}
