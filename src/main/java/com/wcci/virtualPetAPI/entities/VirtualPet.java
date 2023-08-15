package com.wcci.virtualPetAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VirtualPet {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;

    protected String petType = "undefined";
    protected String name;
    protected String description;
    protected int exhaustion;
    protected int happiness;
    protected int petHealth;

    // Constructor
    public VirtualPet(String name, String description,
            int exhaustion, int happiness) {
        this.name = name;
        this.description = description;
        this.exhaustion = exhaustion;
        this.happiness = happiness;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private VirtualPetShelter shelter;

    public VirtualPet() {

    }

    // Getters and Setters
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}