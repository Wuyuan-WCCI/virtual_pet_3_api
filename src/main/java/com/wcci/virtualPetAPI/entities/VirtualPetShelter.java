package com.wcci.virtualPetAPI.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"shelter\"")
public class VirtualPetShelter {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String shelterName;

    private boolean isLitterBoxClean;

    @OneToMany(mappedBy = "shelter")
    private List<VirtualPet> shelterPets = new ArrayList<VirtualPet>();

    public List<VirtualPet> getPets() {
        return shelterPets;
    }

    // Constructor
    public VirtualPetShelter(String shelterName,
            boolean isLitterBoxClean, List<VirtualPet> shelterPets) {
        this.shelterName = shelterName;
        this.isLitterBoxClean = isLitterBoxClean;
        this.shelterPets = shelterPets;
    }

    @ManyToMany(mappedBy = "shelters")
    private List<Volunteer> volunteers = new ArrayList<>();

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public VirtualPetShelter() {

    }

    // Getter Methods
    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public boolean isLitterBoxClean() {
        return isLitterBoxClean;
    }

    public List<VirtualPet> getShelterPets() {
        return shelterPets;
    }

}
