package com.example.demo.service;

import com.example.demo.model.VolunteerSkill;
import java.util.List;

public interface VolunteerSkillService {
    VolunteerSkill save(VolunteerSkill skill);
    List<VolunteerSkill> getAll();
}
