package com.example.demo.repository;

import com.example.demo.model.VolunteerSkillRecord;
import java.util.*;

public interface VolunteerSkillRecordRepository {
    List<VolunteerSkillRecord> findByVolunteerId(Long id);
    List<VolunteerSkillRecord> findBySkillName(String name);
    List<VolunteerSkillRecord> findBySkillNameAndSkillLevel(String n,String l);
    VolunteerSkillRecord save(VolunteerSkillRecord s);
}
