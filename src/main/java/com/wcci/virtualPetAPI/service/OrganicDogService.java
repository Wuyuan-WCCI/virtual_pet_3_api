package com.wcci.virtualPetAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.OrganicDog;
import com.wcci.virtualPetAPI.repositories.OrganicDogRepo;

@Service
public class OrganicDogService {

    @Autowired
    private OrganicDogRepo organicDogRepo;

    public List<OrganicDog> getAllOrganicDogs() {
        return this.organicDogRepo.findAll();
    }

    public OrganicDog getOrganicDogByName(String name) {
        return organicDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Dog not found"));
    }

    public OrganicDog getOrganicDogById(long id) {
        return this.organicDogRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Dog not found: " + id));
    }

    // Get Pet Stats By Name
    public String getDescriptionByName(String name) {
        Optional<OrganicDog> optionalEntity = this.organicDogRepo.findByName(name);
        OrganicDog organicDog = optionalEntity.get();
        return organicDog.getDescription();
    }

    public int getExhaustionByName(String name) {
        this.organicDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicDog> optionalEntity = this.organicDogRepo.findByName(name);
        OrganicDog organicDog = optionalEntity.get();
        return organicDog.getExhaustion();
    }

    public int getHappinessByName(String name) {
        this.organicDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicDog> optionalEntity = this.organicDogRepo.findByName(name);
        OrganicDog organicDog = optionalEntity.get();
        return organicDog.getHappiness();
    }

    public int getWaterNeedByName(String name) {
        this.organicDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicDog> optionalEntity = this.organicDogRepo.findByName(name);
        OrganicDog organicDog = optionalEntity.get();
        return organicDog.getWaterNeed();
    }

    public int getFoodNeedByName(String name) {
        this.organicDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Organic Cat not found: " + name));
        Optional<OrganicDog> optionalEntity = this.organicDogRepo.findByName(name);
        OrganicDog organicDog = optionalEntity.get();
        return organicDog.getFoodNeed();
    }

}
