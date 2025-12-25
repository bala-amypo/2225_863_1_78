package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    public VolunteerProfile getVolunteer(Long id) {
        return service.getVolunteerById(id);
    }

    public void updateAvailability(AvailabilityUpdateRequest request) {
        VolunteerProfile profile =
                service.getVolunteerById(request.getVolunteerId());
        profile.setAvailabilityStatus(request.getAvailabilityStatus());
    }
}
