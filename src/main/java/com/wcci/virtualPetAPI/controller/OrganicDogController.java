package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.OrganicDog;
import com.wcci.virtualPetAPI.service.OrganicDogService;

@RestController
public class OrganicDogController {

    @Autowired
    OrganicDogService organicDogSer;

    @PostMapping("/organicdog/new")
    public void addOrganicDog(@RequestBody OrganicDog oDog) {
        this.organicDogSer.addOrganicDog(oDog);
    }


    @GetMapping("/organicdogs")
    public List<OrganicDog> getOrganicDogs() {
        return organicDogSer.getAllOrganicDogs();
    }

    @GetMapping("/c/{id}")
    public OrganicDog getDogById(@PathVariable long id) {
        return this.organicDogSer.getOrganicDogById(id);
    }

    @GetMapping("/organicdog/name/{name}")
    public OrganicDog getDogByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name);
    }
}
