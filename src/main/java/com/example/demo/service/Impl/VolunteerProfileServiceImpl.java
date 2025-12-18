package com.example.demo.service.impl;

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
    public VolunteerProfile createVolunteer(VolunteerProfile profile) {

        if (repository.existsByEmail(profile.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        if (repository.existsByPhone(profile.getPhone())) {
            throw new RuntimeException("Phone already exists");
        }
        if (repository.existsByVolunteerId(profile.getVolunteerId())) {
            throw new RuntimeException("Volunteer ID already exists");
        }
        return repository.save(profile);
    }

    @Override
    public VolunteerProfile getVolunteerByVolunteerId(String volunteerId) {
        VolunteerProfile profile = repository.findByVolunteerId(volunteerId);
        if (profile == null) {
            throw new RuntimeException("Volunteer not found");
        }
        return profile;
    }

    @Override
    public List<VolunteerProfile> getAllVolunteers() {
        return repository.findAll();
    }

    @Override
    public List<VolunteerProfile> getVolunteersByAvailabilityStatus(String status) {
        return repository.findByAvailabilityStatus(status);
    }

    @Override
    public VolunteerProfile updateVolunteer(Long id, VolunteerProfile profile) {
        VolunteerProfile existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));

        existing.setFullName(profile.getFullName());
        existing.setEmail(profile.getEmail());
        existing.setPhone(profile.getPhone());
        existing.setAvailabilityStatus(profile.getAvailabilityStatus());

        return repository.save(existing);
    }

    @Override
    public void deleteVolunteer(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Volunteer not found");
        }
        repository.deleteById(id);
    }
}
