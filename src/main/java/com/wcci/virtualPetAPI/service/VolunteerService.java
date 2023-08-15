package com.wcci.virtualPetAPI.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.wcci.virtualPetAPI.entities.Volunteer;
import com.wcci.virtualPetAPI.repositories.VolunteerRepo;

@Service
public class VolunteerService {
    @Autowired
    private VolunteerRepo volunteerRepo;

    public void addVolunteer(Volunteer v) {
        this.volunteerRepo.save(v);
    }

    public List<Volunteer> getAllVolunteers() {
        return this.volunteerRepo.findAll();
    }

    public VolunteerService(VolunteerRepo volunteerRepo) {
        this.volunteerRepo = volunteerRepo;
    }

    public Volunteer getVolunteerById(long id) {
        return this.volunteerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer not found: " + id));

    }

    @Transactional
    public void removeVolunteer(String name) {
        this.volunteerRepo.removeByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer not found"));
    }

    public Volunteer getVolunteerByName(String name) {
        return volunteerRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer not found"));
    }

    public Volunteer updateVolunteer(long id, Volunteer updateVolunteer) {
        Volunteer volunteer = this.volunteerRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));

        volunteer.setName(updateVolunteer.getName());
        volunteer.setEmail(updateVolunteer.getEmail());
        volunteer.setAge(updateVolunteer.getAge());
        this.volunteerRepo.save(volunteer);

        return volunteer;
    }

}
