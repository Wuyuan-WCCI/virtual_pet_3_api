package com.wcci.virtualPetAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcci.virtualPetAPI.entities.Volunteer;

@Repository
public interface VolunteerRepo extends JpaRepository<Volunteer, Long> {
    Optional<Volunteer> findByName(String name);

    Optional<Volunteer> removeByName(String name);
}
