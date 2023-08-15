package com.wcci.virtualPetAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.OrganicDog;

@Repository
public interface OrganicDogRepo extends JpaRepository<OrganicDog, String> {

}
