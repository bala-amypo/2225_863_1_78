package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;

public class VolunteerSkillController {

    private final VolunteerSkillService service;

    public VolunteerSkillController(VolunteerSkillService service) {
        this.service = service;
    }

    public VolunteerSkillRecord addSkill(VolunteerSkillRecord record) {
        return service.addOrUpdateSkill(record);
    }
}
