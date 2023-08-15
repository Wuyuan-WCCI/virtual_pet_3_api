package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.repositories.VirtualPetShelterRepo;

@Service
public class VirtualPetShelterService {
    @Autowired
    private VirtualPetShelterRepo shelterRepo;

    public void createShelter(VirtualPetShelter shelter) {
        this.shelterRepo.save(shelter);

    }

    public void deleteShelter(long id) {
        this.shelterRepo.deleteById(id);

    }

    public List<VirtualPetShelter> getAllShelters() {
        return this.shelterRepo.findAll();
    }

    public VirtualPetShelter getShelterById(long id) {
        return this.shelterRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found: " + id));

    }

    public VirtualPetShelter updatesShelter(long id, VirtualPetShelter updateShelter) {
        VirtualPetShelter existingShelter = this.shelterRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));

        existingShelter.setShelterName(updateShelter.getShelterName());

        this.shelterRepo.save(existingShelter);

        return existingShelter;
    }
}
