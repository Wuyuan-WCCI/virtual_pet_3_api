package com.wcci.virtualPetAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.entities.Volunteer;
import com.wcci.virtualPetAPI.repositories.RoboticCatRepo;
import com.wcci.virtualPetAPI.repositories.RoboticDogRepo;
import com.wcci.virtualPetAPI.repositories.VirtualPetShelterRepo;
import com.wcci.virtualPetAPI.repositories.VolunteerRepo;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    private VolunteerRepo volunteerRepo;

    @Autowired
    private VirtualPetShelterRepo shelterRepo;

    @Autowired
    private RoboticDogRepo roboDogRepo;

    @Autowired
    private RoboticCatRepo roboCatRepo;

    public void run(String... args) throws Exception {
        List<VirtualPetShelter> shelters = new ArrayList<VirtualPetShelter>();
        Volunteer volunteer1 = new Volunteer(1, "Leonania", 30, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer1);

        Volunteer volunteer2 = new Volunteer(2, "Leonado", 33, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer2);

        Volunteer volunteer3 = new Volunteer(3, "Leona", 34, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer3);

        VirtualPetShelter shelter1 = new VirtualPetShelter();
        shelter1.setShelterName("FL Shelter");
        shelterRepo.save(shelter1);

        VirtualPetShelter shelter2 = new VirtualPetShelter();
        shelter2.setShelterName("NY Shelter");
        shelterRepo.save(shelter2);

        VirtualPetShelter shelter3 = new VirtualPetShelter();
        shelter3.setShelterName("Ohio Shelter");
        shelterRepo.save(shelter3);

        VirtualPetShelter shelter4 = new VirtualPetShelter();
        shelter4.setShelterName("PA Shelter");
        shelterRepo.save(shelter4);

        VirtualPetShelter shelter5 = new VirtualPetShelter();
        shelter5.setShelterName("LAX Shelter");
        shelterRepo.save(shelter5);

        RoboticDog roboticDog1 = new RoboticDog("Cookie", "Loves the zoomies", 0, 0, 0, 0, false, shelter5);
        roboDogRepo.save(roboticDog1);
        shelter5.getShelterPets().add(roboticDog1);

        RoboticCat roboticCat1 = new RoboticCat("Cloe", "Loves Naps", 0, 0, 0, 0, shelter5);
        roboCatRepo.save(roboticCat1);
        shelter5.getShelterPets().add(roboticCat1);

    }
}