package com.wcci.virtualPetAPI.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "\"organicdog\"")
// @Transactional
public class OrganicDog extends Organic {


    // Fields
    @Id
    @GeneratedValue
    @Column(name = "organicdog_id")
    private long id;

    @Column(name = "pet_type")
    protected String petType = "Dog";

    @Column(name = "hasBeenWalked")
    protected boolean hasBeenWalked;

    @Column(name = "isCageClean")   
    protected boolean isCageClean;

    @JsonIgnore
    @ManyToOne
    @JoinTable(name = "organicdog_shelter", joinColumns = @JoinColumn(name = "organicdog_id"))
    private VirtualPetShelter organicShelterDog;

    // Constructor
    public OrganicDog(String name, String description,int exhaustion, int happiness, int waterNeed, int foodNeed, 
    boolean hasBeenWalked, boolean isCageClean,
    VirtualPetShelter organicShelterDog) {
        super(name, description, exhaustion, happiness,
                waterNeed, foodNeed);
        this.hasBeenWalked = hasBeenWalked;
        this.isCageClean = isCageClean;
        this.organicShelterDog = organicShelterDog;
    }

public OrganicDog(){
}

    // Getter Methods
    public long getId() {
        return id;
    }

    @Override
    public String getPetType() {
        return petType;
    }

    public boolean getHasBeenWalked() {
        return hasBeenWalked;
    }

    public boolean isCageClean() {
        return isCageClean;
    }

    public VirtualPetShelter getOrganicShelterDog() {
        return organicShelterDog;
    }
    public boolean isHasBeenWalked() {
        return this.hasBeenWalked;
    }

    public boolean isIsCageClean() {
        return this.isCageClean;
    }

    public boolean getIsCageClean() {
        return this.isCageClean;
    }


}