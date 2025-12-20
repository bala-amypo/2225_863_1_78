package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "volunteer_profile",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "volunteerId"),
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone")
    }
)
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String volunteerId;

    private String fullName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String availabilityStatus; // AVAILABLE / BUSY / INACTIVE

    private LocalDateTime createdAt;

    // Default constructor
    public VolunteerProfile() {}

    // Parameterized constructor
    public VolunteerProfile(String volunteerId, String fullName, String email,
                            String phone, String availabilityStatus) {
        this.volunteerId = volunteerId;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.availabilityStatus = availabilityStatus;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters & Setters
    public Long getId() { return id; }

    public String getVolunteerId() { return volunteerId; }
    public void setVolunteerId(String volunteerId) { this.volunteerId = volunteerId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAvailabilityStatus() { return availabilityStatus; }
    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
