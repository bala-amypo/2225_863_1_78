package com.example.demo.controller;

import com.example.demo.model.VolunteerSkillRecord;
import com.example.demo.service.VolunteerSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteer-skills")
public class VolunteerSkillController {

    private final VolunteerSkillService volunteerSkillService;

    public VolunteerSkillController(VolunteerSkillService volunteerSkillService) {
        this.volunteerSkillService = volunteerSkillService;
    }

    @PostMapping
    public VolunteerSkillRecord addSkill(@RequestBody VolunteerSkillRecord skill) {
        return volunteerSkillService.addSkill(skill);
    }

    @GetMapping("/volunteer/{volunteerId}")
    public List<VolunteerSkillRecord> getSkillsByVolunteer(@PathVariable Long volunteerId) {
        return volunteerSkillService.getSkillsByVolunteerId(volunteerId);
    }

    @GetMapping("/skill/{skillName}")
    public List<VolunteerSkillRecord> getSkillsByName(@PathVariable String skillName) {
        return volunteerSkillService.getSkillsBySkillName(skillName);
    }

    @GetMapping("/skill/{skillName}/level/{level}")
    public List<VolunteerSkillRecord> getSkillsByNameAndLevel(
            @PathVariable String skillName,
            @PathVariable String level) {
        return volunteerSkillService.getSkillsBySkillNameAndLevel(skillName, level);
    }

    @DeleteMapping("/{id}")
    public String deleteSkill(@PathVariable Long id) {
        volunteerSkillService.deleteSkill(id);
        return "Skill deleted successfully";
    }
}
