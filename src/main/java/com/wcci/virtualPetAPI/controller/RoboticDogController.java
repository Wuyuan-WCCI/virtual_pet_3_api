package com.wcci.virtualPetAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.VirtualPet;
import com.wcci.virtualPetAPI.repositories.RoboticDogRepo;
import com.wcci.virtualPetAPI.service.RoboticDogService;

@RestController
public class RoboticDogController {

    @Autowired
    RoboticDogService roboDogServ;

    @GetMapping("/roboticdog/roboticdogs")
    public List<RoboticDog> findRoboticDogs() {
        return this.roboDogServ.getAllRoboticDogs();
    }

    @GetMapping("/roboticdog/{id}")
    public RoboticDog getRoboticDogById(@PathVariable long id) {
        return this.roboDogServ.getRoboticDogById(id);
    }

    @GetMapping("/roboticdog/name/{name}")
    public RoboticDog getRoboticDogByName(@PathVariable String name) {
        return this.roboDogServ.getRoboticDogByName(name);
    }

}
