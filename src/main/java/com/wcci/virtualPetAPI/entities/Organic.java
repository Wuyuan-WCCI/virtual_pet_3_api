package com.wcci.virtualPetAPI.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Organic extends VirtualPet {
    // Fields
    protected String petType = "undefined organic";
    protected int waterNeed;
    protected int foodNeed;
    protected int organicHealth;

    // Constructor
    public Organic(String name, String description,
            int exhaustion, int happiness, int waterNeed, int foodNeed) {
        super(name, description, exhaustion, happiness);
        this.waterNeed = waterNeed;
        this.foodNeed = foodNeed;
    }

    // Getter Methods
    @Override
    public String getPetType() {
        return petType;
    }

    public int getWaterNeed() {
        return waterNeed;
    }

    public int getFoodNeed() {
        return foodNeed;
    }

    public int getOrganicHealth() {
        organicHealth = petHealth - waterNeed - foodNeed;
        return organicHealth;
    }

}