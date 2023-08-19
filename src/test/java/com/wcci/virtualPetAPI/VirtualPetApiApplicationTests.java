package com.wcci.virtualPetAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.wcci.virtualPetAPI.controller.VolunteerController;
import com.wcci.virtualPetAPI.entities.VirtualPetShelter;
import com.wcci.virtualPetAPI.entities.Volunteer;

@SpringBootTest
class VirtualPetApiApplicationTests {

	private VolunteerController volunteerController;

	@Test
    public void testGetVolunteerByName() {
        List<VirtualPetShelter> shelters = new ArrayList<VirtualPetShelter>();
        Volunteer volunteer3 = new Volunteer(3, "joe", 23, "joe@gmail.com", shelters);
        volunteerController.addVolunteer(volunteer3);
        Volunteer existingVolunteer = volunteerController.getVolunteerById(3);
        assertEquals(volunteer3.getName(), existingVolunteer.getName(), "The names were different");
    }

}
