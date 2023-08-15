package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RoboticDog extends Robotic {
    // Fields
    @Id
    @GeneratedValue
    private long id;
    protected String petType = "Dog";
    protected boolean hasBeenWalked;

    @ManyToOne
    private VirtualPetShelter roboticShelterDog;

    // Constructor
    public RoboticDog(String name, String description,
            int exhaustion, int happiness, int oilNeed, int maintenanceNeed,
            boolean hasBeenWalked, VirtualPetShelter roboticShelterDog) {
        super(name, description, exhaustion, happiness,
                oilNeed, maintenanceNeed);
        this.hasBeenWalked = hasBeenWalked;
        this.roboticShelterDog = roboticShelterDog;
    }

    // Getter Methods
    public long getId() {
        return id;
    }

    @Override
    public String getPetType() {
        return petType;
    }

    public boolean getHasBeenWalked() {
        return hasBeenWalked;
    }

    public VirtualPetShelter getRoboticShelterDog() {
        return roboticShelterDog;
    }

}