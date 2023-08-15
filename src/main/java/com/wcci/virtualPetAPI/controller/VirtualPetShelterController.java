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

import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.service.VirtualPetShelterService;

@RestController
public class VirtualPetShelterController {

    @Autowired
    VirtualPetShelterService virtualPetShelterSer;

    @GetMapping("/shelters/{id}")
    public VirtualPetShelter getShelterById(@PathVariable Long id) {
        return virtualPetShelterSer.getShelterById(id);
    }

    @PostMapping("/shelter/new")
    public void addShelter(@RequestBody VirtualPetShelter shelter) {
        this.virtualPetShelterSer.createShelter(shelter);
    }

    @DeleteMapping("/shelter/delete/{id}")
    public void removeShelter(@PathVariable long id) {
        this.virtualPetShelterSer.deleteShelter(id);
    }

    @PutMapping("/shelter/{id}")
    public VirtualPetShelter findShelterById(@PathVariable long id,
            @RequestBody VirtualPetShelter updateVirtualPetShelter) {
        return this.virtualPetShelterSer.updatesShelter(id, updateVirtualPetShelter);
    }

    @GetMapping("/shelters")
    public List<VirtualPetShelter> getAllShelters() {
        return this.virtualPetShelterSer.getAllShelters();
    }

}