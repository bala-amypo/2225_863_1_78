package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repository;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public VolunteerProfile registerVolunteer(VolunteerProfile profile) {

        if (profile.getEmail() == null || profile.getEmail().isBlank()) {
            throw new BadRequestException("Email is required");
        }

        repository.findByEmail(profile.getEmail()).ifPresent(v -> {
            throw new BadRequestException("Email already exists");
        });

        if (profile.getAvailabilityStatus() == null) {
            profile.setAvailabilityStatus("AVAILABLE");
        }

        return repository.save(profile);
    }

    @Override
    public VolunteerProfile updateAvailability(Long volunteerId, String availabilityStatus) {

        if (!availabilityStatus.equals("AVAILABLE")
                && !availabilityStatus.equals("UNAVAILABLE")) {
            throw new BadRequestException("Invalid availability status");
        }

        VolunteerProfile profile = repository.findById(volunteerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));

        profile.setAvailabilityStatus(availabilityStatus);
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAvailableVolunteers() {
        return repository.findByAvailabilityStatus("AVAILABLE");
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }
}
