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
    public VolunteerProfile create(@RequestBody VolunteerProfile v) {
        return service.create(v);
    }

    @GetMapping("/{id}")
    public VolunteerProfile get(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping
    public List<VolunteerProfile> list() {
        return service.getAll();
    }
}
