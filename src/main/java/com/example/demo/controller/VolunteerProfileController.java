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

    
    @PostMapping
    public VolunteerProfile create(@RequestBody VolunteerProfile profile) {
        return service.create(profile);
    }

    
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.get(id);
    }

    
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAll();
    }

    
    @PutMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {

        return service.updateAvailability(id, status);
    }

    
    @GetMapping("/lookup/{volunteerId}")
    public VolunteerProfile lookup(@PathVariable String volunteerId) {

        return service.getAll()
                .stream()
                .filter(v -> volunteerId.equals(v.getVolunteerId()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));
    }
}
