package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrganicDog extends Organic {
    // Fields
    @Id
    @GeneratedValue
    private long id;
    protected String petType = "Dog";
    protected boolean hasBeenWalked;
    protected boolean isCageClean;

    @ManyToOne
    private VirtualPetShelter organicShelterDog;

    // Constructor
    public OrganicDog(String name, String description,
            int exhaustion, int happiness, int waterNeed, int foodNeed,
            boolean hasBeenWalked, boolean isCageClean,
            VirtualPetShelter organicShelterDog) {
        super(name, description, exhaustion, happiness,
                waterNeed, foodNeed);
        this.hasBeenWalked = hasBeenWalked;
        this.isCageClean = isCageClean;
        this.organicShelterDog = organicShelterDog;
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

    public boolean isCageClean() {
        return isCageClean;
    }

    public VirtualPetShelter getOrganicShelterDog() {
        return organicShelterDog;
    }

}