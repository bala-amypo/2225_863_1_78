package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // POST /api/volunteers
    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.createVolunteer(profile);
    }

    // GET /api/volunteers/{id}
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    // GET /api/volunteers
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAllVolunteers();
    }

    // PUT /api/volunteers/{id}/availability
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateAvailability(id, status);
    }

    // GET /api/volunteers/lookup/{volunteerId}
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile lookup(@PathVariable String volunteerId) {
        return service.findByVolunteerId(volunteerId)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
