package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.*;

public interface VolunteerProfileRepository {
    boolean existsByVolunteerId(String id);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
    Optional<VolunteerProfile> findById(Long id);
    Optional<VolunteerProfile> findByVolunteerId(String id);
    List<VolunteerProfile> findByAvailabilityStatus(String status);
    List<VolunteerProfile> findAll();
    VolunteerProfile save(VolunteerProfile v);
}
