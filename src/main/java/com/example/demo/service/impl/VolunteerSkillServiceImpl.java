package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public VolunteerSkillRecord save(VolunteerSkillRecord skill) {
        return repo.save(skill);
    }

    @Override
    public VolunteerSkillRecord get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<VolunteerSkillRecord> getByVolunteer(Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    @Override
    public List<VolunteerSkillRecord> getAll() {
        return repo.findAll();
    }
}