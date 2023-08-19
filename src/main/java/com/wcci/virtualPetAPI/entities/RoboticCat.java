package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RoboticCat extends Robotic {
    // Fields
    @Id
    @GeneratedValue
    private long id;
    protected String petType = "Cat";

    @ManyToOne
    private VirtualPetShelter roboticShelterCat;

    // Constructor
    public RoboticCat(String name, String description,
            int exhaustion, int happiness, int oilNeed, int maintenanceNeed,
            VirtualPetShelter roboticShelterCat) {
        super(name, description, exhaustion, happiness, oilNeed, maintenanceNeed);
        this.roboticShelterCat = roboticShelterCat;
    }

    public RoboticCat() {

    }

    // Getter Methods
    public long getId() {
        return id;
    }

    @Override
    public String getPetType() {
        return petType;
    }

    public VirtualPetShelter getRoboticShelterCat() {
        return roboticShelterCat;
    }

}