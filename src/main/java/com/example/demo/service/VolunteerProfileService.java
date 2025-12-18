package com.example.demo.service;

import com.example.demo.model.VolunteerProfile;
import java.util.List;

public interface VolunteerProfileService {

    VolunteerProfile createVolunteer(VolunteerProfile profile);

    VolunteerProfile getVolunteerByVolunteerId(String volunteerId);

    List<VolunteerProfile> getAllVolunteers();

    List<VolunteerProfile> getVolunteersByAvailabilityStatus(String status);

    VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile);

    void deleteVolunteer(Long id);
}
