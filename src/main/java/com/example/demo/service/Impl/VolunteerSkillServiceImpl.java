package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkill;
import com.example.demo.repository.VolunteerSkillRecordRepository;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerSkillServiceImpl implements VolunteerSkillService {

    private final VolunteerSkillRecordRepository repository;

    public VolunteerSkillServiceImpl(VolunteerSkillRecordRepository repository) {
        this.repository = repository;
    }

    public VolunteerSkill save(VolunteerSkill skill) {
        return repository.save(skill);
    }

    public List<VolunteerSkill> getAll() {
        return repository.findAll();
    }
}
