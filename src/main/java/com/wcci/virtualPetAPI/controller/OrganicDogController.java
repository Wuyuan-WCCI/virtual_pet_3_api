package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.OrganicDog;
import com.wcci.virtualPetAPI.service.OrganicDogService;

@RestController
public class OrganicDogController {

    @Autowired
    OrganicDogService organicDogSer;


    @GetMapping("/organicdog/organicdogs")
    public List<OrganicDog> getOrganicDogs() {
        return organicDogSer.getAllOrganicDogs();
    }

    @GetMapping("/organicdog/organicdogs/{id}")
    public OrganicDog getDogById(@PathVariable long id) {
        return this.organicDogSer.getOrganicDogById(id);
    }

    @GetMapping("/organicdog/name/{name}")
    public OrganicDog getDogByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name);
    }

    @GetMapping("/organicdog/description/{name}")
    public String getDescriptionByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name).getDescription();
    }

    @GetMapping("/organicdog/exhaustion/{name}")
    public int getExhaustionByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name).getExhaustion();
    }

    @GetMapping("/organicdog/happiness/{name}")
    public int getHappinessByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name).getHappiness();
    }

    @GetMapping("/organicdog/waterneed/{name}")
    public int getWaterNeedByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name).getWaterNeed();
    }

    @GetMapping("/organicdog/foodneed/{name}")
    public int getFoodNeedByName(@PathVariable String name) {
        return this.organicDogSer.getOrganicDogByName(name).getFoodNeed();
    }


}
