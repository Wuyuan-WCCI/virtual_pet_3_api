package com.wcci.virtualPetAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.VirtualPetRepo;
import com.wcci.virtualPetAPI.service.VirtualPetService;
import java.util.List;
import java.util.Optional;

@RestController
public class VirtualPetController {
    @Autowired
    VirtualPetService virtualPetsServ;

    @Autowired
    private VirtualPetRepo virtualPetRepo;

    @PostMapping("pets/new")
    public void addPet(@RequestBody VirtualPet pet) {
        this.virtualPetsServ.createVirtualPet(pet);
    }

    @PutMapping("/pets/{id}")
    public VirtualPet findPetsById(@PathVariable long id, @RequestBody VirtualPet updateVirtualPets) {
        return this.virtualPetsServ.updateVirtualPets(id, updateVirtualPets);
    }

    @DeleteMapping("pets/delete/{id}")
    public void removePet(@PathVariable long id) {
        this.virtualPetsServ.deletePet(id);
    }

    @GetMapping("/pets")
    public List<VirtualPet> findAllPets() {
        return this.virtualPetsServ.getAllPets();
    }

    @GetMapping("/pets/{id}")
    public VirtualPet getPetById(@PathVariable long id) {
        return this.virtualPetsServ.getPetById(id);

    }

    @GetMapping("/{id}")
    public String getPetDetails(@PathVariable Long id, Model model) {
        Optional<VirtualPet> petOptional = virtualPetRepo.findById(id);
        if (petOptional.isPresent()) {
            VirtualPet pet = petOptional.get();
            model.addAttribute("pet", pet);
            return "pet";
        } else {
            return "error";
        }
    }

}