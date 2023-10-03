package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrganicCat extends Organic {
    // Fields
    @Id
    @GeneratedValue
    private long id;
    protected String petType = "Cat";
    private String shelterName;

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    @ManyToOne
    private VirtualPetShelter organicShelterCat;

    // Constructor
    public OrganicCat(String name, String description,
            int exhaustion, int happiness, int waterNeed, int foodNeed,
            String shelterName) {
        super(name, description, exhaustion, happiness,
                waterNeed, foodNeed, shelterName);
        this.shelterName = shelterName;
    }

    public OrganicCat() {
    }

    // Getter Methods
    public long getId() {
        return id;
    }

    @Override
    public String getPetType() {
        return petType;
    }

    public VirtualPetShelter getOrganicShelterCat() {
        return organicShelterCat;
    }

}