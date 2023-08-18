package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.RoboticCatRepo;

@Service
public class RoboticCatService {

    @Autowired
    private RoboticCatRepo roboCatRepo;

    public List<RoboticCat> getAllRoboticCats() {
        return this.roboCatRepo.findAll();
    }

    public RoboticCat getRoboticCatById(long id) {
        return this.roboCatRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));
    }

    public RoboticCat getRoboticCatByName(String name) {
        return roboCatRepo.findByName(name);
    }

}
