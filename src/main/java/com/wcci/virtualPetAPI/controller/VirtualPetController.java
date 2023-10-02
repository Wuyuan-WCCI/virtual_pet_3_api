package com.wcci.virtualPetAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.OrganicDog;
import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.service.VirtualPetService;
import java.util.List;

@RestController
public class VirtualPetController {
    @Autowired
    VirtualPetService virtualPetsServ;

    @PostMapping("virtualpet/pets/new")
    public void addPet(@RequestBody VirtualPet pet) {
        this.virtualPetsServ.createVirtualPet(pet);
    }

    @PutMapping("virtualpet/pets/{id}")
    public VirtualPet findPetsById(@PathVariable long id, @RequestBody VirtualPet updateVirtualPets) {
        return this.virtualPetsServ.updateVirtualPets(id, updateVirtualPets);
    }

    @GetMapping("virtualpet/pets/{id}")
    public VirtualPet getPetById(@PathVariable long id) {
        System.out.println("Pet has been delete!");
        return this.virtualPetsServ.getPetById(id);

    }

    @DeleteMapping("virtualpet/pets/delete/{id}")
    public void removePet(@PathVariable long id) {
        this.virtualPetsServ.deletePet(id);
    }

    @GetMapping("virtualpets")
    public List<VirtualPet> findAllPets() {
        return this.virtualPetsServ.getAllPets();
    }

    @GetMapping("/virtualpet/name/{name}")
    public VirtualPet getPetByName(@PathVariable String name) {
        return this.virtualPetsServ.getPetByName(name);
    }

}