package com.wcci.virtualPetAPI.service;

import java.util.List;

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


}
