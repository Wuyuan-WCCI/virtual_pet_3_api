package com.wcci.virtualPetAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.RoboticCat;
import com.wcci.virtualPetAPI.entities.RoboticDog;
import com.wcci.virtualPetAPI.entities.Volunteer;

@Repository
public interface RoboticCatRepo extends JpaRepository<RoboticCat, Long> {
Optional<RoboticCat> findByName(String name);

}