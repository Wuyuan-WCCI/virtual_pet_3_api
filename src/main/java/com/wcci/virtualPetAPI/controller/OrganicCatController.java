package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.OrganicCat;
import com.wcci.virtualPetAPI.service.OrganicCatService;

@RestController
public class OrganicCatController {

    @Autowired
    OrganicCatService organicCatSer;


    @GetMapping("/organiccats/")
    public List<OrganicCat> getOrganicCats() {
        return organicCatSer.getAllOrganicCats();
    }

    @GetMapping("/organiccat/{id}")
    public OrganicCat getCatById(@PathVariable long id) {
        return this.organicCatSer.getOrganicCatById(id);
    }

    @GetMapping("/organiccat/name/{name}")
    public OrganicCat getCatByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name);
    }

    @GetMapping("/organiccat/description/{name}")
    public String getDescriptionByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name).getDescription();
    }

    @GetMapping("/organiccat/exhaustion/{name}")
    public int getExhaustionByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name).getExhaustion();
    }

    @GetMapping("/organiccat/happiness/{name}")
    public int getHappinessByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name).getHappiness();
    }

    @GetMapping("/organiccat/waterneed/{name}")
    public int getWaterNeedByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name).getWaterNeed();
    }

    @GetMapping("/organiccat/foodneed/{name}")
    public int getFoodNeedByName(@PathVariable String name) {
        return this.organicCatSer.getOrganicCatByName(name).getFoodNeed();
    }


}
