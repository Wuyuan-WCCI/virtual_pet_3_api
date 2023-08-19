package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.Robotic;
import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.RoboticCatRepo;
import com.wcci.virtualPetAPI.service.RoboticCatService;

@RestController
public class RoboticCatController {

    @Autowired
    RoboticCatService roboCatServ;

    @GetMapping("/roboticcat/roboticcats")
    public List<RoboticCat> findRoboticCats() {
        return this.roboCatServ.getAllRoboticCats();
    }

    @GetMapping("/roboticcat/{id}")
    public RoboticCat getRoboticCatById(@PathVariable long id) {
        return this.roboCatServ.getRoboticCatById(id);
    }

    @GetMapping("/roboticcat/name/{name}")
    public RoboticCat getRoboticCatByName(@PathVariable String name) {
        return this.roboCatServ.getRoboticCatByName(name);
    }

}
