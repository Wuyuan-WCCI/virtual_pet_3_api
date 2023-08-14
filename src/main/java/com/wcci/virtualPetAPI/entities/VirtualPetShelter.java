package com.wcci.virtualPetAPI.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VirtualPetShelter {

    //Fields
    @Id
    @GeneratedValue
    private long id;
    private String shelterName;
    private boolean isLitterBoxClean;

    @OneToMany
    private ArrayList<VirtualPet> shelterPets = new ArrayList<VirtualPet>();

    //Constructor
    public VirtualPetShelter(String shelterName,
    boolean isLitterBoxClean, ArrayList<VirtualPet> shelterPets) {
        this.shelterName = shelterName;
        this.isLitterBoxClean = isLitterBoxClean;
        this.shelterPets = shelterPets;
    }

    //Getter Methods
    public String getShelterName() {
        return shelterName;
    }

    public boolean isLitterBoxClean() {
        return isLitterBoxClean;
    }

    public ArrayList<VirtualPet> getShelterPets() {
        return shelterPets;
    }

}
