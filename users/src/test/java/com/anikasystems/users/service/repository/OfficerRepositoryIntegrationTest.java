package com.anikasystems.users.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.anikasystems.users.service.model.Officer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OfficerRepositoryIntegrationTest {
    @Autowired
    OfficerRepository OfficerRepository;

    @Autowired
    TestEntityManager entityManager;

    private final String testEmail = "testUser@fakeEmail.com";

    @Test
    @Order(1)
    public void givenNewOfficer_whenSaved_thenSuccess() {
        //testing the "C" in CRUD
        Officer newOfficer = new Officer("lastName", "firstName", false, "phoneNumber", testEmail, "fieldOffice", "signature", "signaturePath", "sigFileId");
        OfficerRepository.save(newOfficer);
        assert(entityManager.find(Officer.class, newOfficer.getId()).equals(newOfficer));    
    }

    @Test
    @Order(2)
    public void givenExistingOfficer_whenRead_thenSuccess() {
        //testing the 'R' in CRUD
        Officer newOfficer = OfficerRepository.findById(1).get();
        assert(newOfficer.getFirstName().equals("Officer1Frist"));
    }

    @Test
    @Order(3)
    public void givenExistingOfficer_whenUpdated_thenSuccess() {
        //Testing the 'U' in CRUD
        Officer localOfficer = OfficerRepository.findById(1).get();
        localOfficer.email(testEmail);
        //UserRepository.save(localUser);
        assert(entityManager.find(Officer.class, 1).getEmail().equals(testEmail));
    }

    @Test
    @Order(4)
    public void givenExistingOfficer_whenDeleted_thenSuccess() {
        //Testing the 'D' in CRUD
        Optional<Officer> officerData = OfficerRepository.findByEmail(testEmail);
        if(officerData.isPresent()){
            Officer delOfficer = officerData.get();
            OfficerRepository.delete(delOfficer);
            assert(entityManager.find(Officer.class, delOfficer.getId())==null);
        }
        
    }
}