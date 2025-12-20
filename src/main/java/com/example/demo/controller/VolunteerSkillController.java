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

    // POST / - Add/update skill
    @PostMapping
    public VolunteerSkillRecord addOrUpdate(@RequestBody VolunteerSkillRecord skill) {
        return repo.save(skill);
    }

    // GET /volunteer/{volunteerId} - Get skills
    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getByVolunteer(@PathVariable Long volunteerId) {
        return repo.findByVolunteerId(volunteerId);
    }

    // GET /{id} - Get skill
    @GetMapping("/{id}")
    public VolunteerSkillRecord getSkill(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // GET / - List all
    @GetMapping
    public List<VolunteerSkillRecord> getAll() {
        return repo.findAll();
    }
}
