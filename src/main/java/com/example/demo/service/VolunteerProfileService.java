package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {
    VolunteerProfile save(VolunteerProfile profile);
    List<VolunteerProfile> getAll();
}
