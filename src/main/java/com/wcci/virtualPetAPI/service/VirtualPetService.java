package com.wcci.virtualPetAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.VirtualPetRepo;

@Service
public class VirtualPetService {

    @Autowired
    private VirtualPetRepo virtualPetRepo;

    public void createVirtualPet(VirtualPet pet) {
        this.virtualPetRepo.save(pet);

    }

    public void deletePet(long id) {
        this.virtualPetRepo.deleteById(id);

    }

    public List<VirtualPet> getAllPets() {
        return this.virtualPetRepo.findAll();
    }

    public VirtualPet getPetByName(String name) {
        return VirtualPetRepo.findByPetName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer not found"));
    }

    public VirtualPet getPetById(long id) {
        return this.virtualPetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found: " + id));

    }

    public VirtualPet updateVirtualPets(long id, VirtualPet updateVirtualPets) {
        VirtualPet existingPet = this.virtualPetRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + id));

        existingPet.setName(updateVirtualPets.getName());
        existingPet.setDescription(updateVirtualPets.getDescription());
        this.virtualPetRepo.save(existingPet);

        return existingPet;
    }
}
