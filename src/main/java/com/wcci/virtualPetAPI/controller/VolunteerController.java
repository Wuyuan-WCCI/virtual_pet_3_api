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
    public void addVolunteer(@RequestBody Volunteer v) {
        this.volunteerSer.addVolunteer(v);
    }

    @PutMapping("/volunteer/{id}")
    public Volunteer findById(@PathVariable long id, @RequestBody Volunteer updateVolunteer) {
        return this.volunteerSer.updateVolunteer(id, updateVolunteer);
    }

    @DeleteMapping("/volunteer/delete/{name}")
    public void removeVolunteer(@PathVariable String name) {
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

    @GetMapping("/volunteer/name/{name}")
    public Volunteer getVolunteerByName(@PathVariable String name) {
        return this.volunteerSer.getVolunteerByName(name);
    }

}
