package com.example.demo.controller;

import com.example.demo.model.VolunteerSkill;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    @PostMapping
    public VolunteerSkill save(@RequestBody VolunteerSkill skill) {
        return service.save(skill);
    }

    @GetMapping
    public List<VolunteerSkill> getAll() {
        return service.getAll();
    }
}
