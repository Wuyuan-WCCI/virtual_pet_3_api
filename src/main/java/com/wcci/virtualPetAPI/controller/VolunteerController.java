package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.Volunteer;
import com.wcci.virtualPetAPI.service.VolunteerService;

@RestController
public class VolunteerController {

    @Autowired
    VolunteerService volunteerSer;

    @PostMapping("/volunteer/new")
    public void addVolunteer(@RequestBody Volunteer volunteer) {
        this.volunteerSer.addVolunteer(volunteer);
    }

    @PutMapping("/volunteer/{id}")
    public Volunteer modifyVolunteer(@PathVariable long id, @RequestBody Volunteer updateVolunteer) {
        return this.volunteerSer.updateVolunteer(id, updateVolunteer);
    }

    // Delete Volunteer by name
    @DeleteMapping("/volunteer/delete/{name}")
    public void deleteVolunteer(@PathVariable String name) {
        this.volunteerSer.removeVolunteer(name);
    }

    @GetMapping("/volunteers")
    public List<Volunteer> findAllVolunteer() {
        return this.volunteerSer.getAllVolunteers();
    }

    @GetMapping("/volunteer/{id}")
    public Volunteer getVolunteerById(@PathVariable long id) {
        return this.volunteerSer.getVolunteerById(id);

    }

    // Find volunteer by name
    @GetMapping("/volunteer/name/{name}")
    public Volunteer getVolunteerByName(@PathVariable String name) {
        return this.volunteerSer.getVolunteerByName(name);
    }

}
