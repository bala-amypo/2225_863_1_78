package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.repository.VolunteerSkillRecordRepository;

@RestController
@RequestMapping("/api/skills")
public class VolunteerSkillController {

    private final VolunteerSkillRecordRepository repo;

    public VolunteerSkillController(VolunteerSkillRecordRepository repo) {
        this.repo = repo;
    }

   
    @PostMapping
    public VolunteerSkillRecord addOrUpdate(@RequestBody VolunteerSkillRecord skill) {
        return repo.save(skill);
    }

    
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    
    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkill(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

   
    @GetMapping
    public List<VolunteerSkillRecord> getAll() {
        return repo.findAll();
    }
}
