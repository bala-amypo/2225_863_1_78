package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VolunteerSkillRecord;

public interface VolunteerSkillService {

    VolunteerSkillRecord save(VolunteerSkillRecord skill);

    VolunteerSkillRecord get(Long id);

    List<VolunteerSkillRecord> getByVolunteer(Long volunteerId);

    List<VolunteerSkillRecord> getAll();
}