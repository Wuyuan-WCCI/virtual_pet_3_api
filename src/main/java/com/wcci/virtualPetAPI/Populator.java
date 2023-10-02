package com.wcci.virtualPetAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.wcci.virtualPetAPI.entities.OrganicCat;
import com.wcci.virtualPetAPI.entities.OrganicDog;
import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.entities.Volunteer;
import com.wcci.virtualPetAPI.repositories.OrganicCatRepo;
import com.wcci.virtualPetAPI.repositories.OrganicDogRepo;
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
    private OrganicDogRepo organicDogRepo;

    @Autowired
    private OrganicCatRepo organicCatRepo;

    @Autowired
    private RoboticCatRepo roboticCatRepo;

    @Autowired
    private RoboticDogRepo roboticDogRepo;

    public void run(String... args) throws Exception {
        List<VirtualPetShelter> shelters = new ArrayList<>();
        List<Volunteer> volunteers = new ArrayList<>();

        Volunteer volunteer1 = new Volunteer(1, "Leonania", 30, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer1);
        volunteers.add(0, volunteer1);

        Volunteer volunteer2 = new Volunteer(2, "Leonado", 33, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer2);
        volunteers.add(1, volunteer2);

        Volunteer volunteer3 = new Volunteer(3, "Leona", 34, "leolin@gamil.com", shelters);
        volunteerRepo.save(volunteer3);
        volunteers.add(2, volunteer3);

        VirtualPetShelter shelter1 = new VirtualPetShelter(1, "FL Shelter", true, new ArrayList<>(), volunteers);
        shelterRepo.save(shelter1);
        shelters.add(0, shelter1);

        VirtualPetShelter shelter2 = new VirtualPetShelter(2, "NY Shelter", true, new ArrayList<>(), volunteers);
        shelterRepo.save(shelter2);
        shelters.add(1, shelter2);

        VirtualPetShelter shelter3 = new VirtualPetShelter(3, "Ohio Shelter", true, new ArrayList<>(), volunteers);
        shelterRepo.save(shelter3);
        shelters.add(2, shelter3);

        VirtualPetShelter shelter4 = new VirtualPetShelter(4, "PA Shelter", true, new ArrayList<>(), volunteers);
        shelterRepo.save(shelter4);
        shelters.add(3, shelter4);

        VirtualPetShelter shelter5 = new VirtualPetShelter(5, "LA Shelter", true, new ArrayList<>(), volunteers);
        shelterRepo.save(shelter5);
        shelters.add(4, shelter5);
        System.out.println("\n================== Volunters ==================\n");
        for (Volunteer volunteer : volunteers) {
            System.out.println(volunteer);

        }

        System.out.println("\n================== Shelters ==================\n");

        for (VirtualPetShelter shelter : shelters) {
            System.out.println(shelter);
        }

        // Map<Volunteer, List<VirtualPetShelter>> volunteerSheltersMap = new
        // HashMap<>();
        // for (Volunteer volunteer : volunteers) {
        // List<VirtualPetShelter> volunteerShelters = new ArrayList<>();
        // for (VirtualPetShelter shelter : shelters) {
        // volunteerShelters.add(shelter);
        // }
        // volunteerSheltersMap.put(volunteer, volunteerShelters);
        // }

        volunteerRepo.saveAll(volunteers);

        OrganicDog organicDog1 = new OrganicDog("Rocky", "friendly", 0, 0, 0, 0, false, true,
                shelter2.getShelterName());
        organicDogRepo.save(organicDog1);
        shelter2.getShelterPets().add(organicDog1);

        OrganicDog organicDog2 = new OrganicDog("Ali", "quiet", 0, 0, 0, 0, false, true, shelter2.getShelterName());
        organicDogRepo.save(organicDog2);
        shelter2.getShelterPets().add(organicDog2);

        OrganicCat organicCat1 = new OrganicCat("Danny", "", 0, 0, 0, 0, shelter1.getShelterName());
        organicCatRepo.save(organicCat1);
        shelter1.getShelterPets().add(organicCat1);

        OrganicCat organicCat2 = new OrganicCat("Tonny", "", 0, 0, 0, 0, shelter2.getShelterName());
        organicCatRepo.save(organicCat2);
        shelter2.getShelterPets().add(organicCat2);

        RoboticCat roboticCat1 = new RoboticCat("Kitty", null, 0, 0, 0, 0, shelter3.getShelterName());
        roboticCatRepo.save(roboticCat1);
        shelter3.getShelterPets().add(roboticCat1);

        RoboticCat roboticCat2 = new RoboticCat("Mitty", null, 0, 0, 0, 0, shelter4.getShelterName());
        roboticCatRepo.save(roboticCat2);
        shelter4.getShelterPets().add(roboticCat2);

        RoboticDog roboticDog1 = new RoboticDog("Mio", null, 0, 0, 0, 0, false, shelter5.getShelterName());
        roboticDogRepo.save(roboticDog1);
        shelter5.getShelterPets().add(roboticDog1);

        RoboticDog roboticDog2 = new RoboticDog("Mio", null, 0, 0, 0, 0, false, shelter5.getShelterName());
        roboticDogRepo.save(roboticDog2);
        shelter5.getShelterPets().add(roboticDog2);

    }

}