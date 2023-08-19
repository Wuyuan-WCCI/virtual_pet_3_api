package com.wcci.virtualPetAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.VirtualPet;

@Repository
public interface VirtualPetRepo extends JpaRepository<VirtualPet, Long> {
    Optional<VirtualPet> findByName(String name);
}