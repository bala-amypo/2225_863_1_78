package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.demo.model.VolunteerProfile;
import com.example.demo.repository.VolunteerProfileRepository;
import com.example.demo.service.VolunteerProfileService;
import com.example.demo.exception.BadRequestException;

@Service
public class VolunteerProfileServiceImpl implements VolunteerProfileService {

    private final VolunteerProfileRepository repo;

    public VolunteerProfileServiceImpl(VolunteerProfileRepository repo) {
        this.repo = repo;
    }

    // CREATE (ONLY FOR NEW RECORD)
    @Override
    public VolunteerProfile create(VolunteerProfile profile) {

        if (repo.existsByEmail(profile.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        return repo.save(profile);
    }

    // ✅ UPDATE (SEPARATE METHOD)
    @Override
    public VolunteerProfile updateAvailability(Long id, String status) {

        VolunteerProfile existing = repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));

        existing.setAvailabilityStatus(status);

        return repo.save(existing); // UPDATE
    }

    @Override
    public VolunteerProfile get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new BadRequestException("Volunteer not found"));
    }

    @Override
    public List<VolunteerProfile> getAll() {
        return repo.findAll();
    }
}
