package com.example.demo.controller;

import com.example.demo.model.VolunteerSkill;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    // 🔓 Add skill to volunteer
    @PostMapping
    public ResponseEntity<VolunteerSkill> addSkill(@RequestBody VolunteerSkill skill) {
        VolunteerSkill saved = service.addSkill(skill);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // 🔒 Get all skills
    @GetMapping
    public ResponseEntity<List<VolunteerSkill>> getAllSkills() {
        return ResponseEntity.ok(service.getAllSkills());
    }

    // 🔒 Get skills by volunteer id
    @GetMapping("/volunteer/{volunteerId}")
    public ResponseEntity<List<VolunteerSkill>> getByVolunteer(
            @PathVariable Long volunteerId) {
        return ResponseEntity.ok(service.getSkillsByVolunteer(volunteerId));
    }

    // 🔒 Delete skill
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
        service.deleteSkill(id);
        return ResponseEntity.noContent().build();
    }
}
