package com.example.demo.controller;

import com.example.demo.dto.AvailabilityUpdateRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/volunteers")
public class VolunteerProfileController {
    
    private final VolunteerProfileService volunteerService;
    
    public VolunteerProfileController(VolunteerProfileService volunteerService) {
        this.volunteerService = volunteerService;
    }
    
    @PostMapping
    public ResponseEntity<VolunteerProfile> registerVolunteer(@RequestBody RegisterRequest request) {
        VolunteerProfile profile = volunteerService.registerVolunteer(request);
        return ResponseEntity.ok(profile);
    }
    
    @PatchMapping("/{id}/availability")
    public ResponseEntity<VolunteerProfile> updateAvailability(@PathVariable Long id, 
                                                              @RequestBody AvailabilityUpdateRequest request) {
        VolunteerProfile profile = volunteerService.updateAvailability(id, request.getAvailabilityStatus());
        return ResponseEntity.ok(profile);
    }
}