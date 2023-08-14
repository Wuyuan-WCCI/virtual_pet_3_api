package com.wcci.virtualPetAPI.entities;

public class RoboticDog extends Robotic {
    //Fields
    protected String petType = "Dog";

    
    //Getters and Setters
    @Override
    public String getPetType() {
        return petType;
    }
}
