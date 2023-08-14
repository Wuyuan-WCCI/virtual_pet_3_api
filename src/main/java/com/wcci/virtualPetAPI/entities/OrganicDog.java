package com.wcci.virtualPetAPI.entities;

public class OrganicDog extends Organic {
    //Fields
    protected String petType = "Dog";
    protected int cageWaste = 0;

    @Override
    public void tick() {
        age += 1;
        exhaustion += 1;
        waterNeed += 1;
        foodNeed += 1;
        cageWaste += 1;
        checkPetHealth();
        checkOrganicHealth();
    }

    //Getters and Setters
    @Override
    public String getPetType() {
        return petType;
    }

    public int getCageWaste() {
        return cageWaste;
    }

    public void setCageWaste(int cageWaste) {
        this.cageWaste = cageWaste;
    }
    
}
