package com.wcci.virtualPetAPI.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class VirtualPet {
    //Fields
    protected String petType = "undefined";
    protected String name;
    protected String description;
    protected int exhaustion;
    protected int happiness;
    protected int petHealth;

    //Constructor
    public VirtualPet(String name, String description,
        int exhaustion, int happiness) {
        this.name = name;
        this.description = description;
        this.exhaustion = exhaustion;
        this.happiness = happiness;
    }

    //Getters and Setters
    public String getPetType() {
        return petType;
    }

    public String getName() {
        return name;
    }

    public int getExhaustion() {
        return exhaustion;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getPetHealth() {
        petHealth = 50 - exhaustion + happiness;
        return petHealth;
    }

}