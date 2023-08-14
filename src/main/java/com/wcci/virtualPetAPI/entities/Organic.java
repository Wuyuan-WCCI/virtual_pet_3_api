package com.wcci.virtualPetAPI.entities;

public class Organic extends VirtualPet {
    //Fields
    protected String petType = "undefined organic";
    protected boolean isOrganic = true;
    protected int waterNeed = 3;
    protected int foodNeed = 3;
    protected int organicHealth = petHealth - waterNeed - foodNeed;


    //Required Method for Passage of Time
    @Override
    public void tick() {
        age += 1;
        exhaustion += 1;
        waterNeed += 1;
        foodNeed += 1;
        checkPetHealth();
        checkOrganicHealth();
    }

    //Other Pet Methods    
    public void giveWater() {
        waterNeed -= 3;
        if (waterNeed < 0) {
            waterNeed = 0;
        }
    }
    
    public void giveFood() {
        foodNeed -= 4;
        if (foodNeed < 0) {
            foodNeed = 0;
        }
    }

    public void checkOrganicHealth() {
        organicHealth = petHealth - waterNeed - foodNeed;
        if (waterNeed > 9) {
            isAlive = false;
            System.out.println("\n" + name + " died of lack of water.");
        } else if (foodNeed > 9) {
            isAlive = false;
            System.out.println("\n" + name + " died of lack of food.");
        } else if (organicHealth <= 0) {
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

    public int getWaterNeed() {
        return waterNeed;
    }

    public void setWaterNeed(int waterNeed) {
        this.waterNeed = waterNeed;
    }

    public int getFoodNeed() {
        return foodNeed;
    }

    public void setFoodNeed(int foodNeed) {
        this.foodNeed = foodNeed;
    }

    public int getOrganicHealth() {
        return organicHealth;
    }

    public void setOrganicHealth(int organicHealth) {
        this.organicHealth = organicHealth;
    }

    
}