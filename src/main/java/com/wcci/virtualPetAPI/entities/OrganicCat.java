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

    @ManyToOne
    private VirtualPetShelter organicShelterCat;

    // Constructor
    public OrganicCat(String name, String description,
            int exhaustion, int happiness, int waterNeed, int foodNeed,
            VirtualPetShelter organicShelterCat) {
        super(name, description, exhaustion, happiness,
                waterNeed, foodNeed);
        this.organicShelterCat = organicShelterCat;
    }

    public OrganicCat(){
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