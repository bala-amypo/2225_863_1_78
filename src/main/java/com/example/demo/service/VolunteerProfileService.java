package com.example.demo.service;

import java.util.List;
import com.example.demo.model.VolunteerProfile;

public interface VolunteerProfileService {

    VolunteerProfile create(VolunteerProfile profile);

    VolunteerProfile get(Long id);

    List<VolunteerProfile> getAll();
}
