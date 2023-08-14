package com.wcci.virtualPetAPI.entities;

public class RoboticCat extends Robotic {
    //Fields
    protected String petType = "Cat";

    //Getters and Setters
    @Override
    public String getPetType() {
        return petType;
    }
}
