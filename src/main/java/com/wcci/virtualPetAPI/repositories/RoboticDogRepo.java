package com.wcci.virtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.RoboticDog;

@Repository
public interface RoboticDogRepo extends JpaRepository<RoboticDog, Long> {

}