package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import java.util.*;

public class VolunteerSkillServiceImpl {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    public VolunteerSkillRecord addOrUpdateSkill(VolunteerSkillRecord s) {
        return repo.save(s);
    }

    public List<VolunteerSkillRecord> getSkillsByVolunteer(Long id) {
        return repo.findByVolunteerId(id);
    }
}
