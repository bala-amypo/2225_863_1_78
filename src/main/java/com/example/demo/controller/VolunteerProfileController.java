package com.example.demo.controller;

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

    
    @PostMapping
    public VolunteerProfile register(@RequestBody VolunteerProfile profile) {
        return service.registerVolunteer(profile);
    }

    
    @PatchMapping("/{id}/availability")
    public VolunteerProfile updateAvailability(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateAvailability(id, status);
    }

    
    @GetMapping("/{id}")
    public VolunteerProfile getById(@PathVariable Long id) {
        return service.getVolunteerById(id);
    }

    
    @GetMapping("/available")
    public List<VolunteerProfile> getAvailable() {
        return service.getAvailableVolunteers();
    }

    
    @GetMapping
    public List<VolunteerProfile> getAll() {
        return service.getAllVolunteers();
    }
}
