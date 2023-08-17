package com.wcci.virtualPetAPI.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"shelter\"")
public class VirtualPetShelter {

    // Fields
    @Id

    @Column(name = "shelter_id")
    private long shelterId;

    private String shelterName;

    private boolean isLitterBoxClean;

    @OneToMany(mappedBy = "shelter")
    private List<VirtualPet> shelterPets = new ArrayList<VirtualPet>();

    // Constructor
    public VirtualPetShelter(long shelterId, String shelterName,
            boolean isLitterBoxClean, List<VirtualPet> shelterPets, List<Volunteer> volunteers) {
        this.shelterId = shelterId;
        this.shelterName = shelterName;
        this.isLitterBoxClean = isLitterBoxClean;
        this.shelterPets = shelterPets;
        this.volunteers = volunteers;
    }

    @ManyToMany(mappedBy = "shelters", fetch = FetchType.LAZY)
    private List<Volunteer> volunteers = new ArrayList<>();

    public List<Volunteer> getVolunteers() {
        return volunteers;
    }

    public VirtualPetShelter() {

    }

    // Getter Methods

    public long getShelterId() {
        return shelterId;
    }

    public void setShelterId(long shelterId) {
        this.shelterId = shelterId;
    }

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

    @Override
    public String toString() {
        return "\nShelter: ID = " + shelterId + ", \nName = " + shelterName + " \nLitter box clean: " + isLitterBoxClean
                + " \n"
                + volunteers;
    }

}
