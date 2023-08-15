package com.wcci.virtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.RoboticCat;

@Repository
public interface RoboticCatRepo extends JpaRepository<RoboticCat, String> {

}