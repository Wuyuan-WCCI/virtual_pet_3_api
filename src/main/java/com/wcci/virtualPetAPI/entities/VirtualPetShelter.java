package com.wcci.virtualPetAPI.entities;

import java.util.ArrayList;

import java.util.Scanner;

public class VirtualPetShelter {

    //Fields
    private boolean isShelterEmpty = false;
    private String name;
    private int litterBoxWaste = 0;
    private ArrayList<VirtualPet> shelterPets = new ArrayList<VirtualPet>();

    //Getters and Setters
    public boolean isShelterEmpty() {
        return isShelterEmpty;
    }
    public void setShelterEmpty(boolean isShelterEmpty) {
        this.isShelterEmpty = isShelterEmpty;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLitterBoxWaste() {
        return litterBoxWaste;
    }
    public void setLitterBoxWaste(int litterBoxWaste) {
        this.litterBoxWaste = litterBoxWaste;
    }
    public ArrayList<VirtualPet> getShelterPets() {
        return shelterPets;
    }
    public void setShelterPets(ArrayList<VirtualPet> shelterPets) {
        this.shelterPets = shelterPets;
    }


    //Required Method for Passage of Time
    public void tick() {
        for (int i = 0; i < shelterPets.size(); i++) {
            shelterPets.get(i).tick();
            if (shelterPets.get(i) instanceof OrganicCat) {
                litterBoxWaste += 1;
            } 
        }
        wellnessCheck();
        occupancyCheck();
    }

    //Other Shelter Methods
    public void petCare(int careOption, Scanner userInput) {
        if (careOption == 1) {
            for (int i = 0; i < shelterPets.size(); i++) {
                if (shelterPets.get(i) instanceof Organic) {
                    Organic pet = (Organic) shelterPets.get(i);
                    pet.giveWater();
                } 
            }
            System.out.println("\nWATER GIVEN");
        } else if (careOption == 2) {
            for (int i = 0; i < shelterPets.size(); i++) {
                if (shelterPets.get(i) instanceof Organic) {
                    Organic pet = (Organic) shelterPets.get(i);
                    pet.giveFood();
                }
            }
            System.out.println("\nFOOD GIVEN");
        } else if (careOption == 3) {
            for (int i = 0; i < shelterPets.size(); i++) {
                if (shelterPets.get(i) instanceof Robotic) {
                    Robotic pet = (Robotic) shelterPets.get(i);
                    pet.giveOil();
                } 
            }
            System.out.println("\nOIL GIVEN");
        } else if (careOption == 4) {
            for (int i = 0; i < shelterPets.size(); i++) {
                if (shelterPets.get(i) instanceof Robotic) {
                    Robotic pet = (Robotic) shelterPets.get(i);
                    pet.giveMaintenance();
                }
            }
            System.out.println("\nMAINTENANCE GIVEN");
        } else if (careOption == 5) {
            for (int i = 0; i < shelterPets.size(); i++) {
                shelterPets.get(i).rest();
            }
            System.out.println("\nTHEY ALL RESTED");
        } else if (careOption == 6) {
            for (int i = 0; i < shelterPets.size(); i++) {
                shelterPets.get(i).walk();
            }
            System.out.println("\nTHEY ALL WALKED");
        } else if (careOption == 7) {
            System.out.println("\nSelect the number of the pet you would like to play with:");
            for (int i = 0; i < shelterPets.size(); i++) {
                System.out.println("\n" + i + ": " + shelterPets.get(i).getName());
            }
            System.out.print("\n>");
            int selectedPet = userInput.nextInt();
            shelterPets.get(selectedPet).walk();
            shelterPets.get(selectedPet).setHappiness(5);
            System.out.println("\nYOU PLAYED WITH " + shelterPets.get(selectedPet).getName());
        }
    }


    public void wellnessCheck() {
        //Remove Dead Pets from Shelter List
        for (int i = 0; i < shelterPets.size();) {
            if (shelterPets.get(i).isAlive() == false) {
                shelterPets.remove(i);
            } else {
                i++;
            }
            
        }
    }

    public void occupancyCheck() {
        if (shelterPets.size() < 1) {
            System.out.println("\nThe " + getName() + " Pet Shelter has run out of pets.");
            setShelterEmpty(true);
        }
    }




    
}
