package com.wcci.virtualPetAPI;

public class VirtualPet {
    //Fields
    protected String petType = "undefined";
    protected boolean isAlive = true;
    protected String name;
    protected int age = 0;
    protected int exhaustion = 0;
    protected int happiness = 0;
    protected int petHealth = 50;

    //Required Method for Passage of Time
    public void tick() {
        age += 1;
        exhaustion += 1;
        checkPetHealth();
    }

    //Other Pet Methods
    public void walk() {
        exhaustion += 2;
    }

    public void rest() {
        exhaustion -=4;
        if (exhaustion < 0) {
            exhaustion = 0;
        }
    }

    public void checkPetHealth() {
        petHealth = 50 - age - exhaustion + happiness;
        if (age >= 30) {
            isAlive = false;
            System.out.println("\n" + name + " died of old age.");
        } else if (exhaustion > 9) {
            isAlive = false;
            System.out.println("\n" + name + " died of exhaustion.");
        } else if (petHealth <= 0) {
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExhaustion() {
        return exhaustion;
    }

    public void setExhaustion(int exhaustion) {
        this.exhaustion = exhaustion;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getPetHealth() {
        return petHealth;
    }

    public void setPetHealth(int petHealth) {
        this.petHealth = petHealth;
    }


}