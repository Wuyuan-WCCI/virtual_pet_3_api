package com.wcci.virtualPetAPI.entities;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Robotic extends VirtualPet {
    //Fields
    protected String petType = "undefined robotic";
    protected int oilNeed;
    protected int maintenanceNeed;
    protected int roboticHealth;

    //Constructor
    public Robotic(String name, String description,
    int exhaustion, int happiness, int oilNeed, int maintenanceNeed) {
        super(name, description, exhaustion, happiness);
        this.oilNeed = oilNeed;
        this.maintenanceNeed = maintenanceNeed;
    }

    //Getter Methods
    @Override
    public String getPetType() {
        return petType;
    }

    public int getOilNeed() {
        return oilNeed;
    }

    public int getMaintenanceNeed() {
        return maintenanceNeed;
    }

    public int getRoboticHealth() {
        roboticHealth = petHealth - oilNeed - maintenanceNeed;
        return roboticHealth;
    }

}