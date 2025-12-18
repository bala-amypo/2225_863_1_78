package com.example.demo.controller;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService volunteerProfileService;

    public VolunteerProfileController(VolunteerProfileService volunteerProfileService) {
        this.volunteerProfileService = volunteerProfileService;
    }

    @PostMapping
    public VolunteerProfile createVolunteer(@RequestBody VolunteerProfile profile) {
        return volunteerProfileService.createVolunteer(profile);
    }

    @GetMapping("/{volunteerId}")
    public VolunteerProfile getVolunteerByVolunteerId(@PathVariable String volunteerId) {
        return volunteerProfileService.getVolunteerByVolunteerId(volunteerId);
    }

    @GetMapping
    public List<VolunteerProfile> getAllVolunteers() {
        return volunteerProfileService.getAllVolunteers();
    }

    @GetMapping("/status/{status}")
    public List<VolunteerProfile> getVolunteersByStatus(@PathVariable String status) {
        return volunteerProfileService.getVolunteersByAvailabilityStatus(status);
    }

    @PutMapping("/{id}")
    public VolunteerProfile updateVolunteer(
            @PathVariable Long id,
            @RequestBody VolunteerProfile profile) {
        return volunteerProfileService.updateVolunteer(id, profile);
    }

    @DeleteMapping("/{id}")
    public String deleteVolunteer(@PathVariable Long id) {
        volunteerProfileService.deleteVolunteer(id);
        return "Volunteer deleted successfully";
    }
}
