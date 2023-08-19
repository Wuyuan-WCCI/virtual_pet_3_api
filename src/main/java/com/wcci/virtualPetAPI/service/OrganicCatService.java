package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.OrganicCat;
import com.wcci.virtualPetAPI.repositories.OrganicCatRepo;


@Service
public class OrganicCatService {
    
    @Autowired
    private OrganicCatRepo organicCatRepo;



    public List<OrganicCat> getAllOrganicCats() {
        return this.organicCatRepo.findAll();
    }
    
    public OrganicCat getOrganicCatByName(String name) {
        return organicCatRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found"));
    }


    public OrganicCat getOrganicCatById(long id) {
        return this.organicCatRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + id));
    }

    // Get Pet Stats By Name
    public String getDescriptionByName(String name) {
        Optional<OrganicCat> optionalEntity =  this.organicCatRepo.findByName(name);
        OrganicCat organicCat = optionalEntity.get();
        return organicCat.getDescription();
    }

    public int getExhaustionByName(String name) {
        this.organicCatRepo.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicCat> optionalEntity =  this.organicCatRepo.findByName(name);
        OrganicCat organicCat = optionalEntity.get();
        return organicCat.getExhaustion();
    }

    public int getHappinessByName(String name) {
        this.organicCatRepo.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicCat> optionalEntity =  this.organicCatRepo.findByName(name);
        OrganicCat organicCat = optionalEntity.get();
        return organicCat.getHappiness();
    }

    public int getWaterNeedByName(String name) {
        this.organicCatRepo.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicCat> optionalEntity =  this.organicCatRepo.findByName(name);
        OrganicCat organicCat = optionalEntity.get();
        return organicCat.getWaterNeed();
    }

    public int getFoodNeedByName(String name) {
        this.organicCatRepo.findByName(name)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicCat> optionalEntity =  this.organicCatRepo.findByName(name);
        OrganicCat organicCat = optionalEntity.get();
        return organicCat.getFoodNeed();
    }

}
