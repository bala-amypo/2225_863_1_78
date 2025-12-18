package com.example.demo.service;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.List;

public interface VolunteerSkillService {

    VolunteerSkillRecord addSkill(VolunteerSkillRecord skill);

    List<VolunteerSkillRecord> getSkillsByVolunteerId(Long volunteerId);

    List<VolunteerSkillRecord> getSkillsBySkillName(String skillName);

    List<VolunteerSkillRecord> getSkillsBySkillNameAndLevel(String skillName, String level);

    void deleteSkill(Long id);
}
