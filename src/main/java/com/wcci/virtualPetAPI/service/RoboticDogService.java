package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.RoboticDogRepo;

@Service
public class RoboticDogService {

    @Autowired
    private RoboticDogRepo roboDogRepo;

    public List<RoboticDog> getAllRoboticDogs() {
        return this.roboDogRepo.findAll();
    }

    public RoboticDog getRoboticDogById(long id) {
        return this.roboDogRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoboticDog not found:  " + id));
    }

    public RoboticDog getRoboticDogByName(String name) {
        return roboDogRepo.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "RoboticDog not found"));
    }

}