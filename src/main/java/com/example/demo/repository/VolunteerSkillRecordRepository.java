package com.example.demo.repository;

import com.example.demo.model.VolunteerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerSkillRecordRepository extends JpaRepository<VolunteerSkill, Long> {
}
