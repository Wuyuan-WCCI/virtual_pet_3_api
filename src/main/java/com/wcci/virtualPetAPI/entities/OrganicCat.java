package com.wcci.virtualPetAPI.entities;

public class OrganicCat extends Organic {
    //Fields
    protected String petType = "Cat";

    @Override
    public void tick() {
        age += 1;
        exhaustion += 1;
        waterNeed += 1;
        foodNeed += 1;
        checkPetHealth();
        checkOrganicHealth();
    }

    //Getters and Setters
    @Override
    public String getPetType() {
        return petType;
    }
}
