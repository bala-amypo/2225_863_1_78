package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerProfileController {

    private final VolunteerProfileService service;

    public VolunteerProfileController(VolunteerProfileService service) {
        this.service = service;
    }

    // POST /api/volunteers - Create volunteer
    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.create(profile);
    }

    // GET /api/volunteers/{id} - Get volunteer
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.get(id);
    }

    // GET /api/volunteers - List all volunteers
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    // ✅ PUT /api/volunteers/{id}/availability - Update availability
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateAvailability(id, status);
    }

    // GET /api/volunteers/lookup/{volunteerId}
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile lookup(@PathVariable String volunteerId) {

        return service.getAll()
                .stream()
                .filter(v -> volunteerId.equals(v.getVolunteerId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
