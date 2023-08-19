package com.wcci.virtualPetAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.OrganicCat;

@Repository
public interface OrganicCatRepo extends JpaRepository<OrganicCat, Long> {
    Optional<OrganicCat> findById(String name);
    Optional<OrganicCat> findByName(String name);
}