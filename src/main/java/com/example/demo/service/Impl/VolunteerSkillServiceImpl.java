package com.example.demo.service.impl;

import com.example.demo.model.VolunteerSkillRecord;
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

    @Override
    public VolunteerSkillRecord addSkill(VolunteerSkillRecord skill) {
        return repository.save(skill);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsByVolunteerId(Long volunteerId) {
        return repository.findByVolunteerId(volunteerId);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsBySkillName(String skillName) {
        return repository.findBySkillName(skillName);
    }

    @Override
    public List<VolunteerSkillRecord> getSkillsBySkillNameAndLevel(String skillName, String level) {
        return repository.findBySkillNameAndSkillLevel(skillName, level);
    }

    @Override
    public void deleteSkill(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Skill not found");
        }
        repository.deleteById(id);
    }
}
