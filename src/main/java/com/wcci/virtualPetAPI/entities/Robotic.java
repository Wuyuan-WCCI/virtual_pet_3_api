package com.wcci.virtualPetAPI.entities;

public class Robotic extends VirtualPet {
    //Fields
    protected String petType = "undefined robotic";
    protected boolean isOrganic = false;
    protected int oilNeed = 3;
    protected int maintenanceNeed = 3;
    protected int roboticHealth = petHealth - oilNeed - maintenanceNeed;

    
    //Required Method for Passage of Time
    @Override
    public void tick() {
        age += 1;
        exhaustion += 1;
        oilNeed += 1;
        maintenanceNeed += 1;
        checkPetHealth();
        checkRoboticHealth();
    }

    //Other Pet Methods  
    public void giveOil() {
        oilNeed -= 3;
        if (oilNeed < 0) {
            oilNeed = 0;
        }
    }
    
    public void giveMaintenance() {
        maintenanceNeed -= 4;
        if (maintenanceNeed < 0) {
            maintenanceNeed = 0;
        }
    }
    
    public void checkRoboticHealth() {
        roboticHealth = petHealth - oilNeed - maintenanceNeed;
        if (oilNeed > 9) {
            isAlive = false;
            System.out.println("\n" + name + " died of lack of oil.");
        } else if (maintenanceNeed > 9) {
            isAlive = false;
            System.out.println("\n" + name + " died of lack of maintenance.");
        } else if (roboticHealth <= 0) {
            isAlive = false;
            System.out.println("\n" + name + " died of multiple complications.");
        }
    }

    //Getters and Setters
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public boolean isOrganic() {
        return isOrganic;
    }

    public void setOrganic(boolean isOrganic) {
        this.isOrganic = isOrganic;
    }

    public int getOilNeed() {
        return oilNeed;
    }

    public void setOilNeed(int oilNeed) {
        this.oilNeed = oilNeed;
    }

    public int getMaintenanceNeed() {
        return maintenanceNeed;
    }

    public void setMaintenanceNeed(int maintenanceNeed) {
        this.maintenanceNeed = maintenanceNeed;
    }

    public int getRoboticHealth() {
        return roboticHealth;
    }

    public void setRoboticHealth(int roboticHealth) {
        this.roboticHealth = roboticHealth;
    }
    
    
}